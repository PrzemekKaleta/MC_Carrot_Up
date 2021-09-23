package ExtraClass;

import BasisClass.Game;
import DBConnect.GameDAO;
import DBConnect.SuccessDAO;

public class InfoFounder {

    GameDAO gameDAO = new GameDAO();
    SuccessDAO successDAO = new SuccessDAO();




    public String giveMoreInformation(int bufferId){

        Game game = gameDAO.findGameByBufferId(bufferId);

        if(null != game.getGameDescription()){

            System.out.println("jest gra");


        }else{




        }
        return "foo";

    }


}
