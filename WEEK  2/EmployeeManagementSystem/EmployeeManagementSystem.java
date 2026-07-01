import java.util.Scanner;

public class EmployeeManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static Employee[] employees = new Employee[100];
    static int count = 0;

    // Add Employee
    public static void addEmployee() {

        System.out.print("Enter Employee ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Position : ");
        String position = sc.nextLine();

        System.out.print("Enter Salary : ");
        double salary = sc.nextDouble();

        employees[count++] = new Employee(id, name, position, salary);

        System.out.println("\nEmployee Added Successfully.");

    }

    // Search Employee
    public static void searchEmployee() {

        System.out.print("Enter Employee ID : ");
        int id = sc.nextInt();

        for(int i=0;i<count;i++){

            if(employees[i].getEmployeeId()==id){

                System.out.println("\nEmployee Found");

                System.out.println(employees[i]);

                return;

            }

        }

        System.out.println("\nEmployee Not Found.");

    }

    // Display Employees
    public static void displayEmployees(){

        if(count==0){

            System.out.println("\nNo Employee Records.");

            return;

        }

        System.out.println("\n========= Employee List =========");

        for(int i=0;i<count;i++){

            System.out.println(employees[i]);

            System.out.println("-------------------------------");

        }

    }

    // Delete Employee
    public static void deleteEmployee(){

        System.out.print("Enter Employee ID : ");

        int id = sc.nextInt();

        for(int i=0;i<count;i++){

            if(employees[i].getEmployeeId()==id){

                for(int j=i;j<count-1;j++){

                    employees[j]=employees[j+1];

                }

                employees[count-1]=null;

                count--;

                System.out.println("\nEmployee Deleted Successfully.");

                return;

            }

        }

        System.out.println("\nEmployee Not Found.");

    }

    public static void main(String[] args) {

        int choice;

        do{

            System.out.println("\n========== Employee Management ==========");

            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice){

                case 1:
                    addEmployee();
                    break;

                case 2:
                    searchEmployee();
                    break;

                case 3:
                    displayEmployees();
                    break;

                case 4:
                    deleteEmployee();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");

            }

        }while(choice!=5);

    }

}