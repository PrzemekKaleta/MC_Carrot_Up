package DBConnect;

import BasisClass.Kind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KindDAO {

    private static String addKindQuery = "INSERT INTO kind (kind_name, kind_description, kind_ratio) VALUES (?,?,?);";
    private static String getAllKindQuery = "SELECT * FROM kind;";

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

    private ArrayList<Kind> getAllKind(){

        ArrayList<Kind> kindArrayList = new ArrayList<>();


        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getAllKindQuery);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int kindID = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                String kindDescription = rs.getString("kind_description");
                double kindRatio = rs.getDouble("kind_ratio");

                kindArrayList.add(new Kind(kindID,kindName,kindDescription,kindRatio));


            }



        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return kindArrayList;

    }


}
