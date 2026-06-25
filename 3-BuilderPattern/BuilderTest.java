import java.util.Scanner;

public class BuilderTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Computer Builder ===");

        System.out.print("Enter CPU: ");
        String cpu = sc.nextLine();

        System.out.print("Enter RAM: ");
        String ram = sc.nextLine();

        System.out.print("Enter Storage: ");
        String storage = sc.nextLine();

        System.out.print("Enter Graphics Card: ");
        String graphics = sc.nextLine();

        System.out.print("Enter Operating System: ");
        String os = sc.nextLine();

        Computer computer = new Computer.Builder()
                .setCPU(cpu)
                .setRAM(ram)
                .setStorage(storage)
                .setGraphicsCard(graphics)
                .setOperatingSystem(os)
                .build();

        System.out.println();
        computer.display();

        sc.close();
    }
}