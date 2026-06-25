import java.util.Scanner;

public class DecoratorTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Notification Message:");
        String message = sc.nextLine();

        System.out.println("\nChoose Notification Type");
        System.out.println("1. Email");
        System.out.println("2. Email + SMS");
        System.out.println("3. Email + SMS + Slack");

        int choice = sc.nextInt();

        Notifier notifier;

        switch(choice) {

            case 1:
                notifier = new EmailNotifier();
                break;

            case 2:
                notifier = new SMSNotifierDecorator(
                        new EmailNotifier());
                break;

            case 3:
                notifier = new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));
                break;

            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        System.out.println("\nSending Notifications...\n");

        notifier.send(message);

        sc.close();
    }
}