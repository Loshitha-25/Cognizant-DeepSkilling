import java.util.Scanner;

public class SearchTest {

    public static void main(String[] args) {

        Product[] products = {

                new Product(104, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(103, "Mobile", "Electronics"),
                new Product(102, "Watch", "Accessories"),
                new Product(105, "Bag", "Fashion")

        };

        Scanner sc = new Scanner(System.in);

        System.out.println("========== E-COMMERCE SEARCH ==========");

        System.out.println("1. Linear Search");

        System.out.println("2. Binary Search");

        System.out.print("Choose Search Method: ");

        int choice = sc.nextInt();

        System.out.print("Enter Product ID: ");

        int id = sc.nextInt();

        Product result = null;

        switch(choice) {

            case 1:

                result = SearchOperations.linearSearch(products, id);

                break;

            case 2:

                SearchOperations.sortProducts(products);

                result = SearchOperations.binarySearch(products, id);

                break;

            default:

                System.out.println("Invalid Choice.");

                sc.close();

                return;

        }

        if(result != null) {

            System.out.println("\nProduct Found");

            System.out.println("ID : " + result.getProductId());

            System.out.println("Name : " + result.getProductName());

            System.out.println("Category : " + result.getCategory());

        }

        else {

            System.out.println("\nProduct Not Found.");

        }

        sc.close();

    }

}