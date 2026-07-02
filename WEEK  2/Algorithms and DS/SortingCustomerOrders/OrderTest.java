import java.util.Scanner;

public class OrderTest {

    public static void main(String[] args) {

        Order[] orders = {

                new Order(101,"Loshitha",6500),

                new Order(102,"Rahul",2500),

                new Order(103,"Priya",9200),

                new Order(104,"Arun",4300),

                new Order(105,"Divya",7800)

        };

        Scanner sc = new Scanner(System.in);

        System.out.println("========= CUSTOMER ORDER SORTING =========");

        System.out.println("1. Bubble Sort");

        System.out.println("2. Quick Sort");

        System.out.print("Choose Sorting Method : ");

        int choice = sc.nextInt();

        switch(choice){

            case 1:

                SortingOperations.bubbleSort(orders);

                System.out.println("\nOrders Sorted using Bubble Sort");

                break;

            case 2:

                SortingOperations.quickSort(orders,0,orders.length-1);

                System.out.println("\nOrders Sorted using Quick Sort");

                break;

            default:

                System.out.println("Invalid Choice");

                sc.close();

                return;

        }

        SortingOperations.display(orders);

        sc.close();

    }

}