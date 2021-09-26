package ExtraClass;

import BasisClass.Game;
import BasisClass.Tag;
import BasisClass.Training;
import DBConnect.GameDAO;
import DBConnect.SuccessDAO;
import DBConnect.TagDAO;
import DBConnect.TrainingDAO;

import java.util.ArrayList;
import java.util.Iterator;

public class InfoFounder {

    GameDAO gameDAO = new GameDAO();
    TrainingDAO trainingDAO = new TrainingDAO();
    TagDAO tagDAO = new TagDAO();
    SuccessDAO successDAO = new SuccessDAO();




    public String giveMoreInformation(int bufferId){

        Game game = gameDAO.findGameByBufferId(bufferId);

        if(null != game.getGameDescription()){

            return "Game description: " + game.getGameDescription();


        }

        Training training = trainingDAO.findTrainingByBufferId(bufferId);

        if(null != training.getTrainingDescryption()){

            ArrayList<Tag> tags = tagDAO.getAllTagsByTrainingId(training.getTrainingId());

            StringBuilder sb = new StringBuilder();

            sb.append("Training description: ");
            sb.append(training.getTrainingDescryption());


            Iterator<Tag> iterator = tags.iterator();

            while(iterator.hasNext()){

                Tag tag = iterator.next();

                sb.append(tag.getTagName());


            }

            return sb.toString();

        }





        return "foo";

    }


}
