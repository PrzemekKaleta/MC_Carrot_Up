package DBConnect;

import BasisClass.Buffer;
import BasisClass.BufferFull;
import BasisClass.Kind;
import ExtraClass.InfoFounder;

import java.sql.*;
import java.util.ArrayList;

public class BufferDAO {

    private static String getLastBufferQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT 1;";
    private static String getFewLastsBuffersQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT ?;";
    private static String addBufferQuery = "INSERT INTO buffer (buffer_date, buffer_upload, buffer_carrots) VALUES (?, ?, ?);";
    private static String howManyBuffersQuery = "SELECT COUNT(*) as Num FROM buffer";
    private static String getBuffersFromToQuery = "SELECT * FROM buffer WHERE buffer_id BETWEEN ? AND ? ORDER BY buffer_id DESC;";
    private static String getCurrentCarrotsQuery = "SELECT buffer_carrots as bc FROM buffer ORDER BY buffer_id DESC LIMIT 1;";
    private static String getBuffersFromToLimitQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT ?, ?;";


    public double getCurrentCarrots(){

        double currentCarrots = 0.0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getCurrentCarrotsQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                currentCarrots = rs.getDouble("bc");
            }

            connection.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return currentCarrots;

    }

    public int getHowMayBuffers(){

        int howManyBuffers = 0;

        try {
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(howManyBuffersQuery);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                howManyBuffers = rs.getInt("Num");
            }

            connection.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return howManyBuffers;

    }


    public ArrayList<BufferFull> getBuffersFullFromToLimit (int start){

        ArrayList<BufferFull> buffersFull = new ArrayList<>();
        InfoFounder infoFounder = new InfoFounder();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getBuffersFromToLimitQuery);
            ps.setInt(1, start);
            ps.setInt(2, 10);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BufferFull bufferFull = new BufferFull();
                int bufferID = rs.getInt("buffer_id");
                Date bufferDate = rs.getDate("buffer_date");
                double bufferUpload = rs.getDouble("buffer_upload");
                double bufferCarrots = rs.getDouble("buffer_carrots");
                bufferFull.setBufferId(bufferID);
                bufferFull.setBufferDate(bufferDate);
                bufferFull.setBufferUpload(bufferUpload);
                bufferFull.setBufferCarrots(bufferCarrots);
                bufferFull.setMoreInformation(infoFounder.giveMoreInformation(bufferID));
                buffersFull.add(bufferFull);

            }


            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return buffersFull;
    }

    public Buffer getLastBuffer() {

        Buffer buffer = new Buffer();

        try {
            Connection connection = DBUtil.getConn();

            PreparedStatement ps = connection.prepareStatement(getLastBufferQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int bufferID = rs.getInt("buffer_id");
                Date bufferDate = rs.getDate("buffer_date");
                double bufferUpload = rs.getDouble("buffer_upload");
                double bufferCarrots = rs.getDouble("buffer_carrots");
                buffer.setBufferId(bufferID);
                buffer.setBufferDate(bufferDate);
                buffer.setBufferUpload(bufferUpload);
                buffer.setBufferCarrots(bufferCarrots);
            }
            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return buffer;
    }

    public int addBuffer(Buffer buffer) {

        int update = 0;

        try {
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addBufferQuery);
            ps.setDate(1, buffer.getBufferDate());
            ps.setDouble(2, buffer.getBufferUpload());
            ps.setDouble(3, buffer.getBufferCarrots());
            ps.executeUpdate();

            update = getLastBuffer().getBufferId();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return update;
    }
}


