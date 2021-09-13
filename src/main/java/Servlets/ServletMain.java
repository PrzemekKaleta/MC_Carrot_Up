package Servlets;

import BasisClass.Buffer;
import DBConnect.BufferDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class ServletMain extends HttpServlet {

    static private int quantityOfBuffersToGet = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferDAO bufferDAO = new BufferDAO();
        ArrayList<Buffer> buffers = bufferDAO.getFewLastBuffers(quantityOfBuffersToGet);

        request.setAttribute("buffers", buffers);

        System.out.println("Hi There Java");

        getServletContext().getRequestDispatcher("/my.jsp").forward(request,response);

    }
}
