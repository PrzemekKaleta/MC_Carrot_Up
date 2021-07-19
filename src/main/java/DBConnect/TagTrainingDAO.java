package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TagTrainingDAO {

    private static String addTagTrainingQuery = "INSERT INTO tag_training (tag_id, training_id) VALUES (?, ?);";

    public void setAddTagTraining(int tagID, int trainingID){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addTagTrainingQuery);
            ps.setInt(1, tagID);
            ps.setInt(2, trainingID);
            ps.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

}
