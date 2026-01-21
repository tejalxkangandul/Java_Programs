import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class AgeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input birthdate
        System.out.print("Enter birth year: ");
        int y = sc.nextInt();
        System.out.print("Enter birth month: ");
        int m = sc.nextInt();
        System.out.print("Enter birth day: ");
        int d = sc.nextInt();

        // Calculate age
        LocalDate birth = LocalDate.of(y, m, d);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birth, today);
        long totalDays = ChronoUnit.DAYS.between(birth, today);

        // Output
        System.out.println("\nAGE:");
        System.out.println("Years  : " + age.getYears());
        System.out.println("Months : " + age.getMonths());
        System.out.println("Days   : " + age.getDays());
        System.out.println("Total days lived: " + totalDays);
    }
}