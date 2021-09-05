package DBConnect;

import BasisClass.Buffer;
import BasisClass.Training;
import BasisClass.TrainingFull;

import java.sql.*;

public class TrainingDAO {

    private static String addTrainingQuerry = "INSERT INTO training (buffer_id, training_hours, training_description) VALUES (?, ?, ?);";
    private static String getLastTrainingQuery = "SELECT * FROM training ORDER BY training_id DESC LIMIT 1;";
    private static String getLastFullTrainingQuery = "SELECT * FROM training JOIN buffer ON training.buffer_id = buffer.buffer_id ORDER BY training_id DESC LIMIT 1;";

    public void addTraining(Training training){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addTrainingQuerry);
            ps.setInt(1, training.getBufferId());
            ps.setDouble(2, training.getTrainingHours());
            ps.setString(3, training.getTrainingDescryption());
            ps.executeUpdate();

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public TrainingFull getLastFullTraining(){

        TrainingFull trainingFull = new TrainingFull();
        Training training = new Training();
        Buffer buffer = new Buffer();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getLastFullTrainingQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                int bufferID = rs.getInt("buffer_id");
                int trainingID = rs.getInt("training_id");
                Date bufferDate = rs.getDate("buffer_date");
                double bufferUpload = rs.getDouble("buffer_upload");
                double bufferCarrots = rs.getDouble("buffer_carrots");
                double trainingHours = rs.getDouble("training_hours");
                String trainingDescription = rs.getString("training_description");
                buffer.setBufferId(bufferID);
                buffer.setBufferDate(bufferDate);
                buffer.setBufferUpload(bufferUpload);
                buffer.setBufferCarrots(bufferCarrots);
                training.setTrainingId(trainingID);
                training.setBufferId(bufferID);
                training.setTrainingHours(trainingHours);
                training.setTrainingDescryption(trainingDescription);

                trainingFull.setBuffer(buffer);
                trainingFull.setTraining(training);

            }


            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return trainingFull;

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
            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return training;
    }
}
