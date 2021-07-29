package Servlets;

import BasisClass.Buffer;
import BasisClass.Tag;
import BasisClass.Training;
import BasisClass.TrainingFull;
import DBConnect.BufferDAO;
import DBConnect.TagDAO;
import DBConnect.TagTrainingDAO;
import DBConnect.TrainingDAO;
import Tools.MyDateFormatEditor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/trainingAdd")
public class ServletTrainingAdd extends HttpServlet {

    private static double trainingRatio = 0.05;
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

        MyDateFormatEditor formatEditor = new MyDateFormatEditor();
        bufferNext.setBufferDate(formatEditor.formatDate(dateOfTraining));

        bufferNext.setBufferUpload(bufferUpload);
        bufferNext.setBufferCarrots(carrotsNext);

        int idOfNextBuffer = bufferDAO.addBuffer(bufferNext);


        training.setTrainingDescryption(descriptionOfTraining);
        training.setTrainingHours(Double.parseDouble(hoursOfTraining));
        training.setBufferId(idOfNextBuffer);

        trainingDAO.addTraining(training);

        int dualTrainingID = trainingDAO.getLastTraining().getTrainingId();

        try {
            for (int i = 0; i < chosenTags.length; i++) {

                int dualTagID = Integer.parseInt(chosenTags[i]);
                tagTrainingDAO.setAddTagTraining(dualTagID, dualTrainingID);

            }
        }catch (NullPointerException ex){
            ex.printStackTrace();
        }

        ArrayList<Buffer> buffers = bufferDAO.getFewLastBuffers(quantityOfBuffersToGet);
        request.setAttribute("buffers", buffers);

        getServletContext().getRequestDispatcher("/my.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TagDAO tagDAO = new TagDAO();
        TrainingDAO trainingDAO = new TrainingDAO();
        TrainingFull trainingFull = trainingDAO.getLastFullTraining();
        request.setAttribute("trainingHours", trainingFull.getTraining().getTrainingHours());
        request.setAttribute("trainingDescription", trainingFull.getTraining().getTrainingDescryption());
        request.setAttribute("trainingDate", trainingFull.getBuffer().getBufferDate());

        ArrayList<Tag> tags = tagDAO.getAllActiveTags();
        request.setAttribute("tags", tags);

        Date currentDate = Date.valueOf(LocalDate.now());
        request.setAttribute("currentDate", currentDate);

        java.sql.Date date1 = trainingFull.getBuffer().getBufferDate();

        long daysBetween = Duration.between(date1.toLocalDate().atStartOfDay(), currentDate.toLocalDate().atStartOfDay()).toDays();
        request.setAttribute("duration", daysBetween);

        getServletContext().getRequestDispatcher("/trainingAdd.jsp").forward(request,response);

    }
}
