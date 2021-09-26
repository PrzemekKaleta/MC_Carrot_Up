package DBConnect;

import BasisClass.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {

    protected static String addGameQuery = "INSERT INTO game (buffer_id, game_hours, game_description) VALUES (?, ?, ?);";
    protected static String findGameByBufferIdQuery = "SELECT * FROM game WHERE buffer_id = ?;";
    protected static String getSumOfGamesHoursQuery = "SELECT SUM(game_hours) as xyz FROM game;";

    public double getSumOfGamesHours(){

        double sumOfGamesHours = 0.0;

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(getSumOfGamesHoursQuery);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                sumOfGamesHours = rs.getDouble("xyz");
            }

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return sumOfGamesHours;

    }

    public void addGame(Game game){

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(addGameQuery);
            ps.setInt(1, game.getBufferId());
            ps.setDouble(2, game.getGameHours());
            ps.setString(3, game.getGameDescription());
            ps.executeUpdate();

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public Game findGameByBufferId(int bufferId){

        Game game = new Game();

        try{
            Connection connection = DBUtil.getConn();
            PreparedStatement ps = connection.prepareStatement(findGameByBufferIdQuery);
            ps.setInt(1, bufferId);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                game.setGameHours(rs.getDouble("game_hours"));
                game.setGameDescription(rs.getString("game_description"));
                game.setGameId(rs.getInt("game_id"));

            }

            connection.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return game;

    }
}
