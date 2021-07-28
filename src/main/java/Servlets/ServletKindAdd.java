package Servlets;

import BasisClass.Kind;
import DBConnect.KindDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/kind-add")
public class ServletKindAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String kindName = request.getParameter("name");
        String kindDescription = request.getParameter("description");
        double kindRatio = Double.parseDouble(request.getParameter("ratio"));

        Kind kind = new Kind();
        kind.setKindName(kindName);
        kind.setKindDescription(kindDescription);
        kind.setKindRatio(kindRatio);

        KindDAO kindDAO = new KindDAO();
        kindDAO.addKind(kind);



        getServletContext().getRequestDispatcher("/kindAdd.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        KindDAO kindDAO = new KindDAO();

        ArrayList<Kind> kinds = kindDAO.getAllKind();

        request.setAttribute("kinds", kinds);

        getServletContext().getRequestDispatcher("/kindAdd.jsp").forward(request,response);

    }
}
