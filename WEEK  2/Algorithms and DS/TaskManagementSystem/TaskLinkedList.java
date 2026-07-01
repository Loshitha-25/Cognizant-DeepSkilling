public class TaskLinkedList {

    private Task head;

    // Add Task
    public void addTask(Task task) {

        if (head == null) {
            head = task;
        } else {

            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = task;
        }

        System.out.println("Task Added Successfully.");
    }

    // Search Task
    public void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.getTaskId() == id) {

                System.out.println("\nTask Found");

                System.out.printf("%-8s %-25s %-15s%n",
                        "ID", "Task", "Status");

                temp.display();

                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse
    public void displayTasks() {

        if (head == null) {

            System.out.println("No Tasks Available.");

            return;
        }

        Task temp = head;

        System.out.println();

        System.out.printf("%-8s %-25s %-15s%n",
                "ID", "Task", "Status");

        System.out.println("-----------------------------------------------");

        while (temp != null) {

            temp.display();

            temp = temp.next;
        }

    }

    // Delete
    public void deleteTask(int id) {

        if (head == null) {

            System.out.println("Task List Empty.");

            return;
        }

        if (head.getTaskId() == id) {

            head = head.next;

            System.out.println("Task Deleted Successfully.");

            return;
        }

        Task temp = head;

        while (temp.next != null &&
                temp.next.getTaskId() != id) {

            temp = temp.next;
        }

        if (temp.next == null) {

            System.out.println("Task Not Found.");

        } else {

            temp.next = temp.next.next;

            System.out.println("Task Deleted Successfully.");
        }

    }

}