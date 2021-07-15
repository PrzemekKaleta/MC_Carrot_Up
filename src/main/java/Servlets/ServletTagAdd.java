package Servlets;

import BasisClass.Tag;
import DBConnect.TagDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/tag-add")
public class ServletTagAdd extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tagName = request.getParameter("name");
        String tagDescription = request.getParameter("description");

        TagDAO tagDAO = new TagDAO();
        ArrayList<Tag> tags = tagDAO.getAllTags();

        boolean tagCanBeSave = true;

        if(!tags.isEmpty()){

            for(Tag simpleTag : tags) {
                if (simpleTag.getTagName().equals(tagName)) {

                    request.setAttribute("added", false);
                    tagCanBeSave = false;

                }
            }
        }

        if(tagCanBeSave){

                Tag tag = new Tag();
                tag.setTagName(tagName);
                tag.setTagDescription(tagDescription);

                tagDAO.addTag(tag);

                request.setAttribute("added", true);

        }



        request.setAttribute("tags",tagDAO.getAllTags());

        getServletContext().getRequestDispatcher("/tagAdd.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        TagDAO tagDAO = new TagDAO();

        for(Tag tagSingle : tagDAO.getAllTags()){
            System.out.println(tagSingle.getTagName());
        }

        request.setAttribute("tags",tagDAO.getAllTags());

        getServletContext().getRequestDispatcher("/tagAdd.jsp").forward(request,response);

    }
}
