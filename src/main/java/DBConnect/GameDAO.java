package DBConnect;

import BasisClass.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDAO {

    protected static String addGameQuery = "INSERT INTO game (buffer_id, game_hours, game_description) VALUES (?, ?, ?);";


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
}
