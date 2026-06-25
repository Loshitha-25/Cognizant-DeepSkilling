import java.util.Scanner;

public class StrategyTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PaymentContext context = new PaymentContext();

        System.out.println("========== PAYMENT SYSTEM ==========");

        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");

        System.out.print("\nChoose Payment Method: ");

        int choice = sc.nextInt();

        System.out.print("Enter Amount: ");

        double amount = sc.nextDouble();

        switch(choice) {

            case 1:

                context.setPaymentStrategy(new CreditCardPayment());

                break;

            case 2:

                context.setPaymentStrategy(new PayPalPayment());

                break;

            default:

                System.out.println("Invalid Payment Method.");

                sc.close();

                return;

        }

        context.executePayment(amount);

        sc.close();

    }

}