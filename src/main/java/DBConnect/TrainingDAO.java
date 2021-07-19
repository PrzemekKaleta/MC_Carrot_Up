package DBConnect;

import BasisClass.Training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainingDAO {

    private static String addTrainingQuerry = "INSERT INTO training (buffer_id, training_hours, training_description) VALUES (?, ?, ?);";
    private static String getLastTrainingQuery = "SELECT * FROM training ORDER BY training_id DESC LIMIT 1;";

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

    public Training getLastTraining(){

        Training training = new Training();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getLastTrainingQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int trainingID = rs.getInt("training_id");
                int bufferID = rs.getInt("buffer_id");
                double trainingHours = rs.getDouble("training_hours");
                String trainingDescription = rs.getString("training_description");
                training.setTrainingId(trainingID);
                training.setBufferId(bufferID);
                training.setTrainingHours(trainingHours);
                training.setTrainingDescryption(trainingDescription);

            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return training;
    }
}
