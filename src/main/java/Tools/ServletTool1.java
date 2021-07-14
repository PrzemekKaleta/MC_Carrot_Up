package Tools;

import DBConnect.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/t1")
public class ServletTool1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            Connection connection = DBUtil.getConn();
            System.out.println("connection successfully");

        }catch (SQLException ex){

            ex.printStackTrace();
            System.out.println("connection failed");
        }

        getServletContext().getRequestDispatcher("/").forward(request,response);

    }
}
