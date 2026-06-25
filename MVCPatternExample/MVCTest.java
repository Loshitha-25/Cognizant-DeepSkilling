import java.util.Scanner;

public class MVCTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====== STUDENT MANAGEMENT SYSTEM ======");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Grade: ");
        String grade = sc.nextLine();

        Student student = new Student(name, id, grade);

        StudentView view = new StudentView();

        StudentController controller = new StudentController(student, view);

        System.out.println("\nStudent Record Saved Successfully!");

        controller.updateView();

        System.out.println("\nUpdate Student Grade");

        System.out.print("Enter New Grade: ");

        String newGrade = sc.nextLine();

        controller.setStudentGrade(newGrade);

        System.out.println("\nUpdated Student Record");

        controller.updateView();

        sc.close();

    }

}