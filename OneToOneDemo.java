
import java.util.Scanner;

class Passport {

    private String passportNo; // private instance variable
    private String nationality;

    // - A constructor for the Passport class.
    // - It initializes the passport number and nationality when a new Passport object is created.
    // - this.passportNo refers to the class variable, while the parameter passportNo is the value passed in.
    public Passport(String passportNo, String nationality) {
        this.passportNo = passportNo;
        this.nationality = nationality;
    }

    // - Getter methods that allow controlled access to private variables.
    // - getPassportNo() returns the passport number. 
    // - getNationality() returns the nationality.
    public String getPassportNo() {
        return passportNo;
    }

    public String getNationality() {
        return nationality;
    }
}

// - Defines a Person class.
// - Each person will have an ID, name, and a passport (one-to-one relationship).
// - Declares three private variables:
// - id → person’s ID.
// - name → person’s name.
// - passport → a Passport object (association: one person ↔ one passport).
class Person {

    private int id;
    private String name;
    private Passport passport; // one-to-one relationship

    // - Constructor for the Person class.
    // - Initializes ID, name, and passport when a new person is created.
    public Person(int id, String name, Passport passport) {
        this.id = id;
        this.name = name;
        this.passport = passport;
    }

    //- Getter method for id.
    // - Allows access to the person’s ID outside the class.
    public int getId() {
        return id;
    }

    // - Method to display all details of the person.
    // - Prints ID, name, passport number, and nationality.
    // - Notice how it calls passport.getPassportNo() and passport.getNationality() → this shows the one-to-one association.
    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Passport No: " + passport.getPassportNo());
        System.out.println("Nationality: " + passport.getNationality());
    }
}

// - Defines the main class OneToOneDemo.
// - This contains the main() method where program execution starts.
public class OneToOneDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // - Creates an array of Person objects with size n.
        // - This will store all persons entered by the user.
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

            // - Creates a new Passport object with the entered details.
            // - Creates a new Person object with ID, name, and passport.
            // - Stores it in the persons array.
            Passport passport = new Passport(passportNo, nationality);
            persons[i] = new Person(id, name, passport);
        }

        // Search by ID
        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();

        // - Initializes found as false.
        // - Loops through all persons in the array.
        // - If a person’s ID matches searchId, prints their details using displayDetails().
        // - Sets found = true and breaks out of the loop.
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

// - Passport class → holds passport details.
// - Person class → holds person details and has a one-to-one association with Passport.
// - Main program → lets user input multiple persons, stores them in an array, and allows searching by ID to display details.
