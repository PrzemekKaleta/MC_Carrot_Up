package Servlets;

import BasisClass.Buffer;
import BasisClass.BufferFull;
import DBConnect.BufferDAO;
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

    static private int quantityOfBuffersToGet = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferDAO bufferDAO = new BufferDAO();

        int totalBuffers = bufferDAO.getHowMayBuffers();

        int totalPages = totalBuffers / 10;
        if(totalBuffers%10!=0){
            totalPages++;
        }

        int endId = totalBuffers;
        int startId = totalBuffers - 9;

        request.setAttribute("totalPages", totalPages);
        request.setAttribute("buffersQuantity",totalBuffers);


        String tablePage = request.getParameter("tablePage");
        if(null!=tablePage){

            int tablePageNumber = Integer.parseInt(tablePage);
            if(tablePageNumber > 0 && tablePageNumber <= totalPages){

                endId = totalBuffers - (10 * (tablePageNumber - 1));
                startId = totalBuffers - (10 * tablePageNumber) + 1;
                request.setAttribute("tablePage", tablePage);

            }

        }else{
            request.setAttribute("tablePage", 1);
            request.setAttribute("noPrevious",true);
        }

        if(startId <= 1){
            startId = 1;
            request.setAttribute("noNext",true);
        }


        ArrayList<BufferFull> buffers = bufferDAO.getBuffersFullFromTo(startId,endId);

        request.setAttribute("buffers", buffers);

        getServletContext().getRequestDispatcher("/my.jsp").forward(request,response);

    }
}
