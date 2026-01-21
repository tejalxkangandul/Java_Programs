import java.text.SimpleDateFormat;
import java.util.Date;


public class DateDemo {
    public static void main(String args[]) {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy,hh:mm a");
        System.out.println("DATE & TIME: " +sdf.format(now));
    }
}
