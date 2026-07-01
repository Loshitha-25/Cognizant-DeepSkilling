public class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("\nPayment Successful!");
        System.out.println("Amount Rs." + amount + " paid using PayPal.");

    }

}