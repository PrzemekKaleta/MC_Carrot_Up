package Servlets;

import BasisClass.Tag;
import DBConnect.TagDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tag")
public class ServletTag extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tagName = request.getParameter("name");
        boolean isChosen = Boolean.parseBoolean(request.getParameter("change"));



        TagDAO tagDAO = new TagDAO();

        if(isChosen){
            tagDAO.changeActivityTagByName(tagName);
        }

        Tag tag = tagDAO.getTagByName(tagName);

        request.setAttribute("count",tagDAO.countTagById(tag.getTagId()));

        request.setAttribute("tag", tag);
        request.setAttribute("activeTags",tagDAO.getAllActiveTags());
        request.setAttribute("nonActiveTags",tagDAO.getAllNonActiveTags());

        getServletContext().getRequestDispatcher("/tag.jsp").forward(request, response);



    }
}
