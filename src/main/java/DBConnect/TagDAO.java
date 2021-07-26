package DBConnect;

import BasisClass.Tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagDAO {

    private static String addTagQuery = "INSERT INTO tag (tag_name, tag_description, tag_active) VALUES (?,?,?);";
    private static String getAllTagsQuery = "SELECT * FROM tag;";
    private static String getAllTagsByActiveQuery = "SELECT tag_id, tag_name, tag_description FROM tag WHERE tag_active = ?;";
    private static String getTagByNameQuery = "SELECT * FROM tag WHERE tag_name = ?;";
    private static String getActivityTagByNameQuery = "SELECT tag_active FROM tag WHERE tag_name = ?;";
    private static String setActivityTagByNameQuery = "UPDATE tag SET tag_active = ? WHERE tag_name = ?;";
    private static String countTagByIdQuery = "SELECT count(*) as Num FROM tag_training where tag_id = ?;";

    public int countTagById(int tagId){

        int count = 0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(countTagByIdQuery);
            ps.setInt(1,tagId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                count = rs.getInt("Num");
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return count;
    }


    public void addTag(Tag tag){

        try{

            Connection connection = DBUtil.getConn();

            PreparedStatement ps = connection.prepareStatement(addTagQuery);
            ps.setString(1, tag.getTagName());
            ps.setString(2, tag.getTagDescription());
            ps.setBoolean(3, tag.isTagActive());

            ps.executeUpdate();


        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public void changeActivityTagByName(String tagName){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps1 = connection.prepareStatement(getActivityTagByNameQuery);
            ps1.setString(1, tagName);
            ResultSet rs1 = ps1.executeQuery();

            PreparedStatement ps2 = connection.prepareStatement(setActivityTagByNameQuery);

            while(rs1.next()){
            boolean result = rs1.getBoolean("tag_active");

            ps2.setBoolean(1, !result);

            }

            ps2.setString(2, tagName);

            ps2.executeUpdate();


        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }


    public Tag getTagByName(String tagName){

        Tag tag = new Tag();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getTagByNameQuery);
            ps.setString(1, tagName);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                tag.setTagId(rs.getInt("tag_id"));
                tag.setTagName(rs.getString("tag_name"));
                tag.setTagDescription(rs.getString("tag_description"));
                tag.setTagActive(rs.getBoolean("tag_active"));

            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return tag;
    }

    public ArrayList<Tag> getAllTagsByActive(boolean areActive){

            ArrayList<Tag> chosenTags = new ArrayList<>();

            try{
                Connection connection = DBUtil.getConn();
                PreparedStatement ps = connection.prepareStatement(getAllTagsByActiveQuery);
                ps.setBoolean(1, areActive);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int tagID = rs.getInt("tag_id");
                    String tagName = rs.getString("tag_name");
                    String tagDescription = rs.getString("tag_description");
                    chosenTags.add(new Tag(tagID,tagName,tagDescription,areActive));
                }


            }catch (SQLException ex){
                ex.printStackTrace();
            }

            return chosenTags;


    }

    public ArrayList<Tag> getAllActiveTags(){

        return getAllTagsByActive(true);

    }

    public ArrayList<Tag> getAllNonActiveTags(){

        return getAllTagsByActive(false);
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
                String tagDescription = rs.getString("tag_description");
                boolean tagActive = rs.getBoolean("tag_active");
                tags.add(new Tag(tagID,tagName,tagDescription,tagActive));
            }


        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return tags;

    }
}
