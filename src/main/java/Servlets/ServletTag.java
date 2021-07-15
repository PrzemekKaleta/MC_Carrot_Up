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
        TagDAO tagDAO = new TagDAO();

        Tag tag = tagDAO.getTagByName(tagName);
        request.setAttribute("tag", tag);

        request.setAttribute("tags",tagDAO.getAllTags());

        getServletContext().getRequestDispatcher("/tag.jsp").forward(request, response);



    }
}
