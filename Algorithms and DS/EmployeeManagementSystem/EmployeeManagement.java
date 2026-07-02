public class EmployeeManagement {

    private Employee[] employees = new Employee[100];
    private int count = 0;

    // Add Employee
    public void addEmployee(Employee employee) {

        if (count == employees.length) {
            System.out.println("Employee Array is Full.");
            return;
        }

        employees[count++] = employee;
        System.out.println("Employee Added Successfully.");
    }

    // Search Employee
    public void searchEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == id) {

                System.out.println("\nEmployee Found");

                System.out.printf("%-8s %-20s %-20s %-10s%n",
                        "ID", "Name", "Position", "Salary");

                employees[i].display();

                return;
            }

        }

        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    public void displayEmployees() {

        if (count == 0) {

            System.out.println("No Employees Available.");

            return;

        }

        System.out.println();

        System.out.printf("%-8s %-20s %-20s %-10s%n",
                "ID", "Name", "Position", "Salary");

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < count; i++) {

            employees[i].display();

        }

    }

    // Delete Employee
    public void deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].getEmployeeId() == id) {

                for (int j = i; j < count - 1; j++) {

                    employees[j] = employees[j + 1];

                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee Deleted Successfully.");

                return;
            }

        }

        System.out.println("Employee Not Found.");

    }

}