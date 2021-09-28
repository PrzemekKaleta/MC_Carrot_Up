package DBConnect;

import BasisClass.Buffer;
import BasisClass.Training;
import BasisClass.TrainingFull;

import java.sql.*;

public class TrainingDAO {

    private static String addTrainingQuery = "INSERT INTO training (buffer_id, training_hours, training_description) VALUES (?, ?, ?);";
    private static String getLastTrainingQuery = "SELECT * FROM training ORDER BY training_id DESC LIMIT 1;";
    private static String getLastFullTrainingQuery = "SELECT * FROM training JOIN buffer ON training.buffer_id = buffer.buffer_id ORDER BY training_id DESC LIMIT 1;";
    private static String findTrainingByBufferIdQuery = "SELECT * FROM training WHERE buffer_id = ?;";
    private static String getTotalTrainingHoursQuery = "SELECT SUM(training_hours) AS th FROM training;";
    private static String getMaximumLearningHoursOfOneDayQuery = "SELECT MAX(mh)AS mhod FROM (SELECT SUM(training_hours) AS mh FROM training JOIN buffer ON training.buffer_id = buffer.buffer_id GROUP BY buffer.buffer_date) AS bd;";

    public double getMaximumLearningHoursOfOneDay(){

        double maximumLearningHours = 0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getMaximumLearningHoursOfOneDayQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                maximumLearningHours = rs.getDouble("mhod");
            }
            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return maximumLearningHours;

    }

    public double getTotalTrainingHours(){

        double trainingHours = 0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getTotalTrainingHoursQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                trainingHours = rs.getDouble("th");
            }
            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return trainingHours;

    }

    public void addTraining(Training training){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addTrainingQuery);
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


    public Training findTrainingByBufferId(int bufferId){

        Training training = new Training();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(findTrainingByBufferIdQuery);
            ps.setInt(1, bufferId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                training.setTrainingDescryption(rs.getString("training_description"));
                training.setTrainingHours(rs.getDouble("training_hours"));
                training.setTrainingId(rs.getInt("training_id"));
                training.setBufferId(rs.getInt("buffer_id"));
            }

            connection.close();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return training;

    }

}
