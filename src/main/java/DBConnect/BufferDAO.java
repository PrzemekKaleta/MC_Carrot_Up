package DBConnect;

import BasisClass.Buffer;
import BasisClass.Kind;

import java.sql.*;
import java.util.ArrayList;

public class BufferDAO {

    private static String getLastBufferQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT 1;";
    private static String getFewLastsBuffersQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT ?;";
    private static String addBufferQuery = "INSERT INTO buffer (buffer_date, buffer_upload, buffer_carrots) VALUES (?, ?, ?);";
    private static String howManyBuffersQuery = "SELECT COUNT(*) as Num FROM buffer";
    private static String getBuffersFromToQuery = "SELECT * FROM buffer WHERE buffer_id BETWEEN ? AND ? ORDER BY buffer_id DESC;";

    //"SELECT count(*) as Num FROM tag_training where tag_id = ?;";

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

        System.out.println("How many buffers: " + howManyBuffers);
        return howManyBuffers;

    }

    public ArrayList<Buffer> getBuffersFromTo (int startId, int endId){

        ArrayList<Buffer> buffers = new ArrayList<>();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getBuffersFromToQuery);
            ps.setInt(1, startId);
            ps.setInt(2, endId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Buffer buffer = new Buffer();
                int bufferID = rs.getInt("buffer_id");
                Date bufferDate = rs.getDate("buffer_date");
                double bufferUpload = rs.getDouble("buffer_upload");
                double bufferCarrots = rs.getDouble("buffer_carrots");
                buffer.setBufferId(bufferID);
                buffer.setBufferDate(bufferDate);
                buffer.setBufferUpload(bufferUpload);
                buffer.setBufferCarrots(bufferCarrots);
                buffers.add(buffer);

            }


            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return buffers;
    }




    public ArrayList<Buffer> getFewLastBuffers(int bufferQuantity) {

        ArrayList<Buffer> buffers = new ArrayList<>();

        try {
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getFewLastsBuffersQuery);
            ps.setInt(1, bufferQuantity);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Buffer buffer = new Buffer();
                int bufferID = rs.getInt("buffer_id");
                Date bufferDate = rs.getDate("buffer_date");
                double bufferUpload = rs.getDouble("buffer_upload");
                double bufferCarrots = rs.getDouble("buffer_carrots");
                buffer.setBufferId(bufferID);
                buffer.setBufferDate(bufferDate);
                buffer.setBufferUpload(bufferUpload);
                buffer.setBufferCarrots(bufferCarrots);
                buffers.add(buffer);

            }

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return buffers;


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


