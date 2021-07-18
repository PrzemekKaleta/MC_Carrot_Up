package Tools;

import BasisClass.Buffer;
import DBConnect.BufferDAO;

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

@WebServlet("/buffer-add")
public class ServletToolBufferAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bufferDateAsString = request.getParameter("bufferDate");

        Buffer buffer = new Buffer();

        try {

            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(bufferDateAsString);
            Date bufferDate = new java.sql.Date(utilDate.getTime());

            buffer.setBufferDate(bufferDate);

        }catch (ParseException ex){
            ex.printStackTrace();
        }

        double bufferUpload = Double.parseDouble(request.getParameter("bufferUpload"));
        buffer.setBufferUpload(bufferUpload);

        double bufferCarrot = Double.parseDouble(request.getParameter("bufferCarrot"));
        buffer.setBufferCarrots(bufferCarrot);

        BufferDAO bufferDAO = new BufferDAO();
        bufferDAO.addBuffer(buffer);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Date currentDate = Date.valueOf(LocalDate.now());

        request.setAttribute("currentDate", currentDate);

        getServletContext().getRequestDispatcher("/bufferAdd.jsp").forward(request,response);

    }
}
