
import java.util.Scanner;

class Passport {

    private String passportNo;
    private String nationality;

    public Passport(String passportNo, String nationality) {
        this.passportNo = passportNo;
        this.nationality = nationality;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public String getNationality() {
        return nationality;
    }
}

class Person {

    private int id;
    private String name;
    private Passport passport; // one-to-one relationship

    public Person(int id, String name, Passport passport) {
        this.id = id;
        this.name = name;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Passport No: " + passport.getPassportNo());
        System.out.println("Nationality: " + passport.getNationality());
    }
}

public class OneToOneDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Person[] persons = new Person[n];

        // Input details
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for person " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Passport No: ");
            String passportNo = sc.nextLine();

            System.out.print("Nationality: ");
            String nationality = sc.nextLine();

            Passport passport = new Passport(passportNo, nationality);
            persons[i] = new Person(id, name, passport);
        }

        // Search by ID
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();

        boolean found = false;
        for (Person p : persons) {
            if (p.getId() == searchId) {
                System.out.println("\nPassport Details:");
                p.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No person found with ID " + searchId);
        }

        sc.close();
    }
}
