import java.util.Scanner;

public class CommandTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Light light = new Light();

        RemoteControl remote = new RemoteControl();

        System.out.println("========== HOME AUTOMATION ==========");

        System.out.println("1. Turn ON Light");
        System.out.println("2. Turn OFF Light");

        System.out.print("\nEnter your choice: ");

        int choice = sc.nextInt();

        switch(choice) {

            case 1:

                remote.setCommand(new LightOnCommand(light));

                break;

            case 2:

                remote.setCommand(new LightOffCommand(light));

                break;

            default:

                System.out.println("Invalid Choice");

                sc.close();

                return;

        }

        remote.pressButton();

        sc.close();

    }

}