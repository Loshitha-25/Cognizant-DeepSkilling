import java.util.Scanner;

public class ProxyTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter image name: ");
        String imageName = sc.nextLine();

        Image image = new ProxyImage(imageName);

        System.out.println("\nFirst Display:");
        image.display();

        System.out.println("\nSecond Display:");
        image.display();

        sc.close();
    }
}