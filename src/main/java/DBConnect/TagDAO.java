package DBConnect;

import BasisClass.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagDAO {

    private static String addTagQuery = "INSERT INTO tag (tag_name, tag_description) VALUES (?,?);";
    private static String getAllTagsQuery = "SELECT * FROM tag;";

    public void addTag(Tag tag){

        try{
            Connection connection = DBUtil.getConn();

            PreparedStatement ps = connection.prepareStatement(addTagQuery);
            ps.setString(1, tag.getTagName());
            ps.setString(2, tag.getTagDescription());

            ps.executeQuery();


        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public ArrayList<Tag> getAllTags(){

        ArrayList<Tag> tags = new ArrayList<>();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getAllTagsQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int tagID = rs.getInt("tag_id");
                String tagName = rs.getString("tag_name");
                String tagDesrcription = rs.getString("tag_description");
                tags.add(new Tag(tagID,tagName,tagDesrcription));
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return tags;

    }
}
