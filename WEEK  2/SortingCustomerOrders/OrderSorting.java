import java.util.Scanner;

public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;

                }

            }

        }

    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);

        }

    }

    private static int partition(Order[] orders, int low, int high) {

        double pivot = orders[high].getTotalPrice();

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].getTotalPrice() <= pivot) {

                i++;

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;

            }

        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;

    }

    // Display Orders
    public static void displayOrders(Order[] orders) {

        System.out.println("\n==============================");

        for (Order order : orders) {

            System.out.println(order);
            System.out.println("------------------------------");

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====== Customer Order Sorting ======");

        System.out.print("Enter Number of Orders : ");
        int n = sc.nextInt();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Details for Order " + (i + 1));

            System.out.print("Order ID : ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Customer Name : ");
            String name = sc.nextLine();

            System.out.print("Total Price : ");
            double price = sc.nextDouble();

            orders[i] = new Order(id, name, price);

        }

        System.out.println("\nChoose Sorting Algorithm");

        System.out.println("1. Bubble Sort");

        System.out.println("2. Quick Sort");

        System.out.print("Enter Choice : ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:

                bubbleSort(orders);

                System.out.println("\nOrders Sorted Using Bubble Sort");

                displayOrders(orders);

                break;

            case 2:

                quickSort(orders, 0, orders.length - 1);

                System.out.println("\nOrders Sorted Using Quick Sort");

                displayOrders(orders);

                break;

            default:

                System.out.println("Invalid Choice");

        }

        sc.close();

    }
}