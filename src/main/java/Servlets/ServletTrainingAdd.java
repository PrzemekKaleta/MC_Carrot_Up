package Servlets;

import BasisClass.Tag;
import DBConnect.TagDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/trainingAdd")
public class ServletTrainingAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TagDAO tagDAO = new TagDAO();

        ArrayList<Tag> tags = tagDAO.getAllTags();
        request.setAttribute("tags", tags);

        Date currentDate = Date.valueOf(LocalDate.now());
        request.setAttribute("currentDate", currentDate);

        getServletContext().getRequestDispatcher("/trainingAdd.jsp").forward(request,response);

    }
}
