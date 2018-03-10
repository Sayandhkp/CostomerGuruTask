import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {

        String todate, fromdate;


        do {
            scanner = new Scanner(System.in);
            System.out.println("Enter the from date in dd/MM/yyyy format");
            fromdate = scanner.next();


        } while (!checkDateFormate(fromdate));


        do {
            scanner = new Scanner(System.in);
            System.out.println("Enter the to date in dd/MM/yyyy format");
            todate = scanner.next();

        } while (!checkDateFormate(todate));

        Date[] dateReturn=mainFunction(dateFormat.parse(fromdate),dateFormat.parse(todate));
        System.out.println("From date return =" +dateFormat.format(dateReturn[0]));
        System.out.println("To date return =" + dateFormat.format(dateReturn[1]));
    }

    private  static Date[] mainFunction(Date fromDate,Date toDate){
        Date[]values=new Date[2];

        values[0]=getLastDateOfMonth(fromDate,false);
        values[1]=getLastDateOfMonth(toDate,true);

        return values;
    }

    private static Date getLastDateOfMonth(Date date, Boolean last) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (last) {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));


            if (c.getTime().after(Calendar.getInstance().getTime())){
                return Calendar.getInstance().getTime();
            }
        } else {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));

        }
        return c.getTime();


    }



    private static Boolean checkDateFormate(String value) {
        Date date = null;
        try {
            date = dateFormat.parse(value);
            if (!value.equals(dateFormat.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            System.out.println("Invalid Date format");
            return false;
        }
        if (date == null) {
            System.out.println("Invalid Date format");
            return false;
        } else {
            return true;
        }
    }
}

