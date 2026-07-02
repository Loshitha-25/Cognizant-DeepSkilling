import java.util.Scanner;

public class TaskTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TaskLinkedList taskList = new TaskLinkedList();

        while (true) {

            System.out.println("\n==================================");
            System.out.println(" TASK MANAGEMENT SYSTEM ");
            System.out.println("==================================");

            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Task ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Task Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Status : ");
                    String status = sc.nextLine();

                    taskList.addTask(
                            new Task(id, name, status));

                    break;

                case 2:

                    System.out.print("Enter Task ID : ");
                    taskList.searchTask(sc.nextInt());

                    break;

                case 3:

                    taskList.displayTasks();

                    break;

                case 4:

                    System.out.print("Enter Task ID : ");
                    taskList.deleteTask(sc.nextInt());

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