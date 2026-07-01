import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManagement management = new EmployeeManagement();

        while (true) {

            System.out.println("\n======================================");
            System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
            System.out.println("======================================");

            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Position : ");
                    String position = sc.nextLine();

                    System.out.print("Enter Salary : ");
                    double salary = sc.nextDouble();

                    management.addEmployee(
                            new Employee(id, name, position, salary));

                    break;

                case 2:

                    System.out.print("Enter Employee ID : ");
                    management.searchEmployee(sc.nextInt());

                    break;

                case 3:

                    management.displayEmployees();

                    break;

                case 4:

                    System.out.print("Enter Employee ID : ");
                    management.deleteEmployee(sc.nextInt());

                    break;

                case 5:

                    System.out.println("Thank You!");

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}