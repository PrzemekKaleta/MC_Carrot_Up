package DBConnect;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DBUtil {

    private static DataSource ds;
    public static Connection getConn() throws SQLException{
        return getInstance().getConnection();
    }

    private static DataSource getInstance(){
        if(ds==null){
            try{

                Context ctx = new InitialContext();
                Class.forName("com.mysql.jdbc.Driver");
                Context initContext = new InitialContext();
                Context envContext = (Context)initContext.lookup("java:/comp/env");
                ds = (DataSource)envContext.lookup("jdbc/learn");
            }catch (NamingException ex){
                ex.printStackTrace();
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
        return ds;
    }

}


