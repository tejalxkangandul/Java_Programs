import java.text.DecimalFormat;
public class IndianNumberFormat {
    public static void main(String args[]) {
        double value = 12356.90;

        DecimalFormat df = new DecimalFormat("#,###.00");

        String formatted = df.format(value);
        System.out.println("Formatted number: " +formatted);
    }
}
