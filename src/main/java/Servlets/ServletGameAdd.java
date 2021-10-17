package Servlets;

import BasisClass.Buffer;
import BasisClass.Game;
import DBConnect.BufferDAO;
import DBConnect.GameDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/game-add")
public class ServletGameAdd extends HttpServlet {

    private static double gamingRatio = -1.0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dateOfGaming = request.getParameter("date");
        String hoursOfGaming = request.getParameter("hours");
        String descriptionOfGaming = request.getParameter("description");

        BufferDAO bufferDAO = new BufferDAO();
        GameDAO gameDAO = new GameDAO();

        Buffer bufferNext = new Buffer();
        Game game = new Game();

        Buffer bufferPrevious = bufferDAO.getLastBuffer();
        double carrotsPrevious = bufferPrevious.getBufferCarrots();
        double bufferUpload = Double.parseDouble(hoursOfGaming) * gamingRatio;
        double carrotsNext = carrotsPrevious + bufferUpload;

        try{
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfGaming);
            Date trainingDateToBuffer = new java.sql.Date(utilDate.getTime());
            bufferNext.setBufferDate(trainingDateToBuffer);

        }catch(ParseException ex){
            ex.printStackTrace();
        }

        bufferNext.setBufferUpload(bufferUpload);
        bufferNext.setBufferCarrots(carrotsNext);

        int idOfNextBuffer = bufferDAO.addBuffer(bufferNext);

        game.setGameDescription(descriptionOfGaming);
        game.setGameHours(Double.parseDouble(hoursOfGaming));
        game.setBufferId(idOfNextBuffer);

        gameDAO.addGame(game);

        response.sendRedirect("/#progress");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferDAO bufferDAO = new BufferDAO();
        double carrots = bufferDAO.getLastBuffer().getBufferCarrots();

        request.setAttribute("carrots", carrots);
        Date currentDate = Date.valueOf(LocalDate.now());
        request.setAttribute("currentDate", currentDate);

        getServletContext().getRequestDispatcher("/gameAdd.jsp").forward(request,response);


    }
}
