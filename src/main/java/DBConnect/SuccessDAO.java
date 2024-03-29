package DBConnect;

import BasisClass.Success;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuccessDAO {

    private static String addSuccessQuery = "INSERT INTO success (buffer_id, kind_id, success_description) VALUES (?, ?, ?);";
    private static String findDateOfLastUseOfKindQuery = "SELECT buffer_date FROM buffer JOIN success ON buffer.buffer_id = success.buffer_id WHERE kind_id = ? ORDER BY buffer_date DESC LIMIT 1;";
    private static String countAllRepeatOfKindByKindIdQuery = "SELECT count(1) as Num FROM success WHERE kind_id = ?;";
    private static String findSuccesByBufferIdQuery = "SELECT * FROM success WHERE buffer_id = ?;";
    private static String countAllSuccessQuery = "SELECT COUNT(*) AS cas FROM success;";

    public int countAllSuccess(){

        int allSuccess = 0;

        try{

            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(countAllSuccessQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                allSuccess = rs.getInt("cas");
            }

            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return allSuccess;
    }


    public Success findSuccesByBufferId(int bufferId){

        Success success = new Success();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(findSuccesByBufferIdQuery);
            ps.setInt(1, bufferId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                success.setBufferID(rs.getInt("buffer_id"));
                success.setKindID(rs.getInt("kind_id"));
                success.setSuccessID(rs.getInt("success_id"));
                success.setSuccessDescription(rs.getString("success_description"));

            }

            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return success;
    }



    public int countAllRepeatOfKind(int kindId){

        int count = 0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(countAllRepeatOfKindByKindIdQuery);
            ps.setInt(1, kindId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                count = rs.getInt("Num");
            }

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return count;
    }


    public String getFindDateOfLastUseOfKind(int kindId){

        String strDate = "0";

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(findDateOfLastUseOfKindQuery);
            ps.setInt(1, kindId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                strDate = rs.getString("buffer_date");
            }

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return strDate;
    }

    public void addSuccess (Success success){

        try{

            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addSuccessQuery);
            ps.setInt(1, success.getBufferID());
            ps.setInt(2, success.getKindID());
            ps.setString(3, success.getSuccessDescription());
            ps.executeUpdate();

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }
}
