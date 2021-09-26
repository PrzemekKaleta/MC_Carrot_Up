package ExtraClass;

import BasisClass.*;
import DBConnect.*;

import java.util.ArrayList;
import java.util.Iterator;

public class InfoFounder {

    GameDAO gameDAO = new GameDAO();
    TrainingDAO trainingDAO = new TrainingDAO();
    TagDAO tagDAO = new TagDAO();
    SuccessDAO successDAO = new SuccessDAO();
    KindDAO kindDAO = new KindDAO();



    public String giveMoreInformation(int bufferId){

        Game game = gameDAO.findGameByBufferId(bufferId);

        if(null != game.getGameDescription()){

            return "GAME description: " + game.getGameDescription();


        }

        Training training = trainingDAO.findTrainingByBufferId(bufferId);

        if(null != training.getTrainingDescryption()){

            ArrayList<Tag> tags = tagDAO.getAllTagsByTrainingId(training.getTrainingId());

            StringBuilder sb = new StringBuilder();

            sb.append("TRAINING description: ");
            sb.append(training.getTrainingDescryption());

            int tagsSize = tags.size();

            Iterator<Tag> iterator = tags.iterator();

            if(tagsSize == 1){
                sb.append(" Tag: ");
            }else if(tagsSize > 1){
                sb.append(" Tags: ");
            }


            while(iterator.hasNext()){

                Tag tag = iterator.next();

                sb.append("<a href='/tag?name=" + tag.getTagName() + "'>" + tag.getTagName() + "</a> ");


            }

            return sb.toString();

        }

        Success success = successDAO.findSuccesByBufferId(bufferId);

        if(null != success.getSuccessDescription()){

            StringBuilder sb = new StringBuilder();

            sb.append("SUCCESS ");

            Kind kind = kindDAO.getKindById(success.getKindID());

            sb.append("<a href='/kind?name=" + kind.getKindName() + "'>" + kind.getKindName() + "</a>");

            sb.append(" description: ");
            sb.append(success.getSuccessDescription());

            return sb.toString();
        }



        return "Not found";

    }


}
