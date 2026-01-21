
import java.util.*;

class Employee {

    private int empId;
    private String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId + ", Name: " + name);
    }
}

class Department {

    private int deptId;
    private String deptName;
    private List<Employee> employees; // One-to-Many relationship

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void displayDetails() {
        System.out.println("\nDepartment ID: " + deptId);
        System.out.println("Department Name: " + deptName);
        System.out.println("Employees:");
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}

public class OneToManyDemo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of departments: ");
        int deptCount = sc.nextInt();
        sc.nextLine();

        Department[] departments = new Department[deptCount];

        // Input details for departments and employees
        for (int i = 0; i < deptCount; i++) {
            System.out.println("\nEnter details for Department " + (i + 1) + ":");
            System.out.print("Department ID: ");
            int deptId = sc.nextInt();
            sc.nextLine();

            System.out.print("Department Name: ");
            String deptName = sc.nextLine();

            Department dept = new Department(deptId, deptName);

            System.out.print("Enter number of employees in this department: ");
            int empCount = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < empCount; j++) {
                System.out.println("Enter details for Employee " + (j + 1) + ":");
                System.out.print("Employee ID: ");
                int empId = sc.nextInt();
                sc.nextLine();

                System.out.print("Employee Name: ");
                String empName = sc.nextLine();

                Employee emp = new Employee(empId, empName);
                dept.addEmployee(emp);
            }

            departments[i] = dept;
        }

        // Search department by ID
        System.out.print("\nEnter Department ID to search: ");
        int searchDeptId = sc.nextInt();

        boolean found = false;
        for (Department d : departments) {
            if (d.getDeptId() == searchDeptId) {
                d.displayDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No department found with ID " + searchDeptId);
        }

        sc.close();
    }
}
