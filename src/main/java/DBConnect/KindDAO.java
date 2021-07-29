package DBConnect;

import BasisClass.Kind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KindDAO {

    private static String addKindQuery = "INSERT INTO kind (kind_name, kind_description, kind_ratio) VALUES (?,?,?);";
    private static String getAllKindQuery = "SELECT * FROM kind ORDER BY kind_ratio ASC;";
    private static String getKindByNameQuery = "SELECT * FROM kind WHERE kind_name = ?;";
    private static String getKindByIdQuery = "SELECT * FROM kind WHERE kind_id = ?;";

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

    public ArrayList<Kind> getAllKind(){

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

    public Kind getKindByName(String name){

        Kind kind = new Kind();
        kind.setKindId(0);

        try{

            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getKindByNameQuery);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int kindID = rs.getInt("kind_id");
                String kindName = rs.getString("kind_name");
                String kindDescription = rs.getString("kind_description");
                double kindRatio = rs.getDouble("kind_ratio");

                kind.setKindRatio(kindRatio);
                kind.setKindDescription(kindDescription);
                kind.setKindName(kindName);
                kind.setKindId(kindID);

            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return kind;

    }

    public Kind getKindById (int kindId){

        Kind kind = new Kind();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getKindByIdQuery);
            ps.setInt(1, kindId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                kind.setKindId(kindId);
                kind.setKindName(rs.getString("kind_name"));
                kind.setKindDescription(rs.getString("kind_description"));
                kind.setKindRatio(rs.getDouble("kind_ratio"));

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return kind;

    }


}
