package DBConnect;

import BasisClass.Success;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuccessDAO {

    private static String addSuccessQuery = "INSERT INTO success (buffer_id, kind_id, success_description) VALUES (?, ?, ?);";


    public void addSuccess (Success success){

        try{

            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addSuccessQuery);
            ps.setInt(1, success.getBufferID());
            ps.setInt(2, success.getKindID());
            ps.setString(3, success.getSuccessDescription());
            ps.executeUpdate();


        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }
}
