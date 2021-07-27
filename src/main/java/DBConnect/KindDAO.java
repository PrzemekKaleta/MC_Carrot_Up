package DBConnect;

import BasisClass.Kind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KindDAO {

    private static String addKindQuery = "INSERT INTO kind (kind_name, kind_description, kind_ratio) VALUES (?,?,?);";

    public void addKind(Kind kind){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addKindQuery);
            ps.setString(1, kind.getKindName());
            ps.setString(2, kind.getKindDescription());
            ps.setDouble(3, kind.getKindRatio());
            ps.executeUpdate();


        }catch(SQLException ex){
            ex.printStackTrace();
        }


    }


}
