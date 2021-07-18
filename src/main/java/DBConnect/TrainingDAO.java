package DBConnect;

import BasisClass.Training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TrainingDAO {

    private static String addTrainingQuerry = "INSERT INTO training (buffer_id, training_hours, training_description) VALUES (?, ?, ?);";

    public void addTraining(Training training){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addTrainingQuerry);
            ps.setInt(1, training.getBufferId());
            ps.setDouble(2, training.getTrainingHours());
            ps.setString(3, training.getTrainingDescryption());
            ps.executeUpdate();


        }catch (SQLException ex){
            ex.printStackTrace();
        }



    }
}
