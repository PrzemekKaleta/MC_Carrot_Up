package BasisClass;

public class Game {

    private int gameId;
    private int bufferId;
    private double gameHours;
    private String gameDescription;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getBufferId() {
        return bufferId;
    }

    public void setBufferId(int bufferId) {
        this.bufferId = bufferId;
    }

    public double getGameHours() {
        return gameHours;
    }

    public void setGameHours(double gameHours) {
        this.gameHours = gameHours;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }
}
