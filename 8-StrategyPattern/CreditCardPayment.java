public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount) {

        System.out.println("\nPayment Successful!");
        System.out.println("Amount Rs." + amount + " paid using Credit Card.");

    }

}