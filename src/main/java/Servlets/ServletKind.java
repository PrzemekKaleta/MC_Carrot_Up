package Servlets;

import BasisClass.Kind;
import DBConnect.KindDAO;
import DBConnect.SuccessDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/kind")
public class ServletKind extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String kindName = request.getParameter("name");

        KindDAO kindDAO = new KindDAO();

        if(null!=kindName){
            Kind kind = kindDAO.getKindByName(kindName);

            Double proportion = 20 * kind.getKindRatio();


            SuccessDAO successDAO = new SuccessDAO();

            String lastDateOfKind = successDAO.getFindDateOfLastUseOfKind(kind.getKindId());
            int counter = successDAO.countAllRepeatOfKind(kind.getKindId());

            request.setAttribute("kind", kind);

            request.setAttribute("proportion", proportion);

            request.setAttribute("count", counter);

            request.setAttribute("lastDate", lastDateOfKind);


        }



        ArrayList<Kind> kinds = kindDAO.getAllKind();

        request.setAttribute("kinds", kinds);


        getServletContext().getRequestDispatcher("/kind.jsp").forward(request,response);

    }
}
