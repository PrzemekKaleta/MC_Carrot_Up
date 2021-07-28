package Servlets;

import BasisClass.Kind;
import DBConnect.BufferDAO;
import DBConnect.KindDAO;
import DBConnect.SuccessDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet("/success-add")
public class ServletSuccessAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SuccessDAO successDAO = new SuccessDAO();



        KindDAO kindDAO = new KindDAO();
        ArrayList<Kind> kinds= kindDAO.getAllKind();
        request.setAttribute("kinds", kinds);

        BufferDAO bufferDAO = new BufferDAO();
        double carrots = bufferDAO.getLastBuffer().getBufferCarrots();
        request.setAttribute("carrots", carrots);

        Date currentDate = Date.valueOf(LocalDate.now());
        request.setAttribute("currentDate", currentDate);

        getServletContext().getRequestDispatcher("/successAdd.jsp").forward(request,response);

    }
}
