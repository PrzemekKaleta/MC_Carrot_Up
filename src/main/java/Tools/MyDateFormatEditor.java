package Tools;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyDateFormatEditor {

    public Date formatDate (String dateStr){

        Date date = null;

        try{
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            date = new java.sql.Date(utilDate.getTime());

        }catch(ParseException ex){
            ex.printStackTrace();
        }

        return date;

    }
}
