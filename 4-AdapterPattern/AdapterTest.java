import java.util.Scanner;

public class AdapterTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Payment Gateway");
        System.out.println("1. PayPal");
        System.out.println("2. Stripe");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        PaymentProcessor processor;

        switch(choice) {

            case 1:
                processor = new PayPalAdapter();
                break;

            case 2:
                processor = new StripeAdapter();
                break;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        processor.processPayment(amount);

        sc.close();
    }
}