package Servlets;

import BasisClass.Buffer;
import BasisClass.Kind;
import BasisClass.Success;
import DBConnect.BufferDAO;
import DBConnect.KindDAO;
import DBConnect.SuccessDAO;
import Tools.MyDateFormatEditor;

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

    static private int quantityOfBuffersToGet = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int chosenKindId = Integer.parseInt(request.getParameter("chosenKind"));

        MyDateFormatEditor formatEditor = new MyDateFormatEditor();
        Date dateOfSuccess = formatEditor.formatDate(request.getParameter("date"));

        String succesDescription = request.getParameter("description");

        BufferDAO bufferDAO = new BufferDAO();
        SuccessDAO successDAO = new SuccessDAO();
        KindDAO kindDAO = new KindDAO();

        Kind kind = kindDAO.getKindById(chosenKindId);

        Buffer lastBuffer = bufferDAO.getLastBuffer();

        Double lastCarrot = lastBuffer.getBufferCarrots();

        Double nextBufferUpload = kind.getKindRatio();
        Double nextBufferCarrots = lastCarrot + nextBufferUpload;

        Buffer nextBuffer = new Buffer(dateOfSuccess, nextBufferUpload,nextBufferCarrots);

        int nextBufferId = bufferDAO.addBuffer(nextBuffer);

        Success success = new Success(nextBufferId,chosenKindId,succesDescription);
        successDAO.addSuccess(success);

        response.sendRedirect("/#progress");

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
