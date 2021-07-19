package Servlets;

import BasisClass.Buffer;
import BasisClass.Tag;
import BasisClass.Training;
import DBConnect.BufferDAO;
import DBConnect.TagDAO;
import DBConnect.TagTrainingDAO;
import DBConnect.TrainingDAO;

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

@WebServlet("/trainingAdd")
public class ServletTrainingAdd extends HttpServlet {

    protected static double trainingRatio = 0.05;
    static private int quantityOfBuffersToGet = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dateOfTraining = request.getParameter("date");
        String hoursOfTraining = request.getParameter("hours");
        String descriptionOfTraining = request.getParameter("description");
        String[] chosenTags = request.getParameterValues("chosenTags");

        BufferDAO bufferDAO = new BufferDAO();
        TrainingDAO trainingDAO = new TrainingDAO();
        TagTrainingDAO tagTrainingDAO = new TagTrainingDAO();

        Buffer bufferNext = new Buffer();
        Training training = new Training();

        Buffer bufferPrevious = bufferDAO.getLastBuffer();
        double carrotsPrevious = bufferPrevious.getBufferCarrots();
        double bufferUpload = Double.parseDouble(hoursOfTraining) * trainingRatio;
        double carrotsNext = carrotsPrevious + bufferUpload;

        try{
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfTraining);
            Date trainingDateToBuffer = new java.sql.Date(utilDate.getTime());
            bufferNext.setBufferDate(trainingDateToBuffer);

        }catch(ParseException ex){
            ex.printStackTrace();
        }

        bufferNext.setBufferUpload(bufferUpload);
        bufferNext.setBufferCarrots(carrotsNext);

        int idOfNextBuffer = bufferDAO.addBuffer(bufferNext);
        System.out.println("ID IS " + idOfNextBuffer);

        training.setTrainingDescryption(descriptionOfTraining);
        training.setTrainingHours(Double.parseDouble(hoursOfTraining));
        training.setBufferId(idOfNextBuffer);

        trainingDAO.addTraining(training);

        int dualTrainingID = trainingDAO.getLastTraining().getTrainingId();


        for(int i = 0; i < chosenTags.length; i++){

            int dualTagID = Integer.parseInt(chosenTags[i]);
            tagTrainingDAO.setAddTagTraining(dualTagID, dualTrainingID);

        }

        ArrayList<Buffer> buffers = bufferDAO.getFewLastBuffers(quantityOfBuffersToGet);
        request.setAttribute("buffers", buffers);

        getServletContext().getRequestDispatcher("/my.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TagDAO tagDAO = new TagDAO();

        ArrayList<Tag> tags = tagDAO.getAllActiveTags();
        request.setAttribute("tags", tags);

        Date currentDate = Date.valueOf(LocalDate.now());
        request.setAttribute("currentDate", currentDate);

        getServletContext().getRequestDispatcher("/trainingAdd.jsp").forward(request,response);

    }
}
