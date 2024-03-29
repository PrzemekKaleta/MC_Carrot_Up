package Servlets;

import BasisClass.Buffer;
import BasisClass.BufferFull;
import DBConnect.BufferDAO;
import DBConnect.GameDAO;
import DBConnect.SuccessDAO;
import DBConnect.TrainingDAO;
import ExtraClass.InfoFounder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class ServletMain extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferDAO bufferDAO = new BufferDAO();

        GameDAO gameDAO = new GameDAO();

        double currentCarrots = bufferDAO.getCurrentCarrots();
        request.setAttribute("currentCarrots", currentCarrots);

        double sumOfGamesHours = gameDAO.getSumOfGamesHours();
        request.setAttribute("sumOfGamesHours", sumOfGamesHours);

        TrainingDAO trainingDAO = new TrainingDAO();
        double sumOfTrainingHours = trainingDAO.getTotalTrainingHours();
        request.setAttribute("sumOfTrainingHours", sumOfTrainingHours);

        double maxLearningHours = trainingDAO.getMaximumLearningHoursOfOneDay();
        request.setAttribute("maxLearningHours", maxLearningHours);

        SuccessDAO successDAO = new SuccessDAO();
        int allSuccess = successDAO.countAllSuccess();
        request.setAttribute("allSuccess", allSuccess);



        int totalBuffers = bufferDAO.getHowMayBuffers();

        System.out.println("Total buffers " + totalBuffers);

        int totalPages = totalBuffers / 10;
        if(totalBuffers%10!=0){
            totalPages++;
        }

        int startId = 0;

        request.setAttribute("totalPages", totalPages);
        request.setAttribute("buffersQuantity",totalBuffers);


        String tablePage = request.getParameter("tablePage");
        if(null!=tablePage){

            int tablePageNumber = Integer.parseInt(tablePage);
            if(tablePageNumber > 0 && tablePageNumber <= totalPages){

                startId = tablePageNumber * 10 - 10;
                request.setAttribute("tablePage", tablePage);

            }

        }else{
            request.setAttribute("tablePage", 1);
            request.setAttribute("noPrevious",true);
        }

        if(startId <= 1){
            startId = 0;
            request.setAttribute("noNext",true);
        }

        System.out.println("Start ID " + startId);

        ArrayList<BufferFull> buffers = bufferDAO.getBuffersFullFromToLimit(startId);

        request.setAttribute("buffers", buffers);

        getServletContext().getRequestDispatcher("/my.jsp").forward(request,response);

    }
}
