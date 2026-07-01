import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String title) {

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                return book;

            }

        }

        return null;

    }

    // Binary Search
    public static Book binarySearch(Book[] books, String title) {

        Arrays.sort(books, Comparator.comparing(Book::getTitle));

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int result = books[mid].getTitle().compareToIgnoreCase(title);

            if (result == 0) {

                return books[mid];

            }

            else if (result < 0) {

                left = mid + 1;

            }

            else {

                right = mid - 1;

            }

        }

        return null;

    }

    // Display Result
    public static void display(Book book) {

        if (book != null) {

            System.out.println("\nBook Found");

            System.out.println("-----------------------");

            System.out.println(book);

        }

        else {

            System.out.println("\nBook Not Found.");

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Books : ");

        int n = sc.nextInt();

        sc.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Book " + (i + 1));

            System.out.print("Book ID : ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Title : ");
            String title = sc.nextLine();

            System.out.print("Author : ");
            String author = sc.nextLine();

            books[i] = new Book(id, title, author);

        }

        System.out.println("\nChoose Search Algorithm");

        System.out.println("1. Linear Search");

        System.out.println("2. Binary Search");

        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();

        sc.nextLine();

        System.out.print("\nEnter Book Title to Search : ");

        String searchTitle = sc.nextLine();

        switch (choice) {

            case 1:

                System.out.println("\nUsing Linear Search...");

                display(linearSearch(books, searchTitle));

                break;

            case 2:

                System.out.println("\nUsing Binary Search...");

                display(binarySearch(books, searchTitle));

                break;

            default:

                System.out.println("Invalid Choice.");

        }

        sc.close();

    }

}