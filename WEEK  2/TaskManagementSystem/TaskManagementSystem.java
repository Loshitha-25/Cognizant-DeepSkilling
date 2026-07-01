import java.util.Scanner;

public class TaskManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static Task head = null;

    // Add Task
    public static void addTask() {

        System.out.print("Enter Task ID : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Task Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Status : ");
        String status = sc.nextLine();

        Task newTask = new Task(id, name, status);

        if (head == null) {

            head = newTask;

        } else {

            Task temp = head;

            while (temp.next != null) {

                temp = temp.next;

            }

            temp.next = newTask;

        }

        System.out.println("\nTask Added Successfully.");

    }

    // Search Task
    public static void searchTask() {

        if (head == null) {

            System.out.println("\nNo Tasks Available.");

            return;

        }

        System.out.print("Enter Task ID : ");
        int id = sc.nextInt();

        Task temp = head;

        while (temp != null) {

            if (temp.getTaskId() == id) {

                System.out.println("\nTask Found\n");

                System.out.println(temp);

                return;

            }

            temp = temp.next;

        }

        System.out.println("\nTask Not Found.");

    }

    // Display Tasks
    public static void displayTasks() {

        if (head == null) {

            System.out.println("\nNo Tasks Available.");

            return;

        }

        Task temp = head;

        System.out.println("\n========== TASK LIST ==========");

        while (temp != null) {

            System.out.println(temp);

            System.out.println("-------------------------");

            temp = temp.next;

        }

    }

    // Delete Task
    public static void deleteTask() {

        if (head == null) {

            System.out.println("\nNo Tasks Available.");

            return;

        }

        System.out.print("Enter Task ID : ");
        int id = sc.nextInt();

        if (head.getTaskId() == id) {

            head = head.next;

            System.out.println("\nTask Deleted Successfully.");

            return;

        }

        Task temp = head;

        while (temp.next != null && temp.next.getTaskId() != id) {

            temp = temp.next;

        }

        if (temp.next == null) {

            System.out.println("\nTask Not Found.");

        } else {

            temp.next = temp.next.next;

            System.out.println("\nTask Deleted Successfully.");

        }

    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n========== TASK MANAGEMENT ==========");

            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addTask();
                    break;

                case 2:
                    searchTask();
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("\nThank You!");
                    break;

                default:
                    System.out.println("\nInvalid Choice.");

            }

        } while (choice != 5);

    }

}