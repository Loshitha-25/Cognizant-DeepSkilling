public class SortingOperations {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for(int i=0;i<n-1;i++) {

            for(int j=0;j<n-i-1;j++) {

                if(orders[j].getTotalPrice() >
                        orders[j+1].getTotalPrice()) {

                    Order temp = orders[j];
                    orders[j]=orders[j+1];
                    orders[j+1]=temp;

                }

            }

        }

    }

    // Quick Sort

    public static void quickSort(Order[] orders,int low,int high){

        if(low<high){

            int pi = partition(orders,low,high);

            quickSort(orders,low,pi-1);

            quickSort(orders,pi+1,high);

        }

    }

    private static int partition(Order[] orders,int low,int high){

        double pivot = orders[high].getTotalPrice();

        int i = low-1;

        for(int j=low;j<high;j++){

            if(orders[j].getTotalPrice() < pivot){

                i++;

                Order temp=orders[i];
                orders[i]=orders[j];
                orders[j]=temp;

            }

        }

        Order temp=orders[i+1];
        orders[i+1]=orders[high];
        orders[high]=temp;

        return i+1;

    }

    // Display

    public static void display(Order[] orders){

        System.out.println();

        System.out.printf("%-10s %-20s %-15s%n",
                "OrderID","Customer","Total Price");

        System.out.println("-----------------------------------------------");

        for(Order order:orders){

            System.out.printf("%-10d %-20s ₹%-15.2f%n",

                    order.getOrderId(),

                    order.getCustomerName(),

                    order.getTotalPrice());

        }

    }

}