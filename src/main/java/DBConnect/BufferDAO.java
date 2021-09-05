package DBConnect;

import BasisClass.Buffer;
import BasisClass.Kind;

import java.sql.*;
import java.util.ArrayList;

public class BufferDAO {

    private static String getLastBufferQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT 1;";
    private static String getFewLastsBuffersQuery = "SELECT * FROM buffer ORDER BY buffer_id DESC LIMIT ?;";
    private static String addBufferQuery = "INSERT INTO buffer (buffer_date, buffer_upload, buffer_carrots) VALUES (?, ?, ?);";


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


