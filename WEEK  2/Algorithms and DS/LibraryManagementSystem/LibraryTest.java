import java.util.Scanner;

public class LibraryTest {

    public static void main(String[] args) {

        Book[] books = {

                new Book(101, "Java Programming", "James Gosling"),
                new Book(102, "Python Basics", "Guido van Rossum"),
                new Book(103, "Data Structures", "Mark Allen"),
                new Book(104, "Operating Systems", "Galvin"),
                new Book(105, "Database Systems", "Elmasri")

        };

        Scanner sc = new Scanner(System.in);

        System.out.println("========== LIBRARY MANAGEMENT SYSTEM ==========");

        System.out.println("1. Linear Search");

        System.out.println("2. Binary Search");

        System.out.print("Choose Search Method: ");

        int choice = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Book Title: ");

        String title = sc.nextLine();

        Book result = null;

        switch (choice) {

            case 1:

                result = SearchOperations.linearSearch(books, title);

                break;

            case 2:

                SearchOperations.sortBooks(books);

                result = SearchOperations.binarySearch(books, title);

                break;

            default:

                System.out.println("Invalid Choice.");

                sc.close();

                return;

        }

        if (result != null) {

            System.out.println("\nBook Found");

            System.out.printf("%-8s %-30s %-20s%n",
                    "ID",
                    "Title",
                    "Author");

            result.display();

        }

        else {

            System.out.println("\nBook Not Found.");

        }

        sc.close();

    }

}