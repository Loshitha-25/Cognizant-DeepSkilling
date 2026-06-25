import java.util.Scanner;

public class DependencyInjectionTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        System.out.println("====== CUSTOMER MANAGEMENT SYSTEM ======");

        System.out.print("Enter Customer ID: ");

        int id = sc.nextInt();

        service.getCustomerDetails(id);

        sc.close();

    }

}