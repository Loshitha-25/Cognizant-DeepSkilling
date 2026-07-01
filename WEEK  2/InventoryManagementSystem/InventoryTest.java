import java.util.Scanner;

public class InventoryTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        InventoryManagement inventory = new InventoryManagement();

        while (true) {

            System.out.println("\n======================================");

            System.out.println(" WAREHOUSE INVENTORY MANAGEMENT SYSTEM ");

            System.out.println("======================================");

            System.out.println("1. Add Product");

            System.out.println("2. View Products");

            System.out.println("3. Search Product");

            System.out.println("4. Update Product");

            System.out.println("5. Delete Product");

            System.out.println("6. Inventory Value");

            System.out.println("7. Exit");

            System.out.print("\nEnter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID : ");

                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name : ");

                    String name = sc.nextLine();

                    System.out.print("Enter Quantity : ");

                    int qty = sc.nextInt();

                    System.out.print("Enter Price : ");

                    double price = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter Category : ");

                    String category = sc.nextLine();

                    inventory.addProduct(new Product(id, name, qty, price, category));

                    break;

                case 2:

                    inventory.displayProducts();

                    break;

                case 3:

                    System.out.print("Enter Product ID : ");

                    inventory.searchProduct(sc.nextInt());

                    break;

                case 4:

                    System.out.print("Enter Product ID : ");

                    id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter New Name : ");

                    name = sc.nextLine();

                    System.out.print("Enter New Quantity : ");

                    qty = sc.nextInt();

                    System.out.print("Enter New Price : ");

                    price = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter New Category : ");

                    category = sc.nextLine();

                    inventory.updateProduct(id, name, qty, price, category);

                    break;

                case 5:

                    System.out.print("Enter Product ID : ");

                    inventory.deleteProduct(sc.nextInt());

                    break;

                case 6:

                    inventory.totalInventoryValue();

                    break;

                case 7:

                    System.out.println("Thank You!");

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}