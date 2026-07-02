public class CustomerService {

    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {

        this.repository = repository;

    }

    public void getCustomerDetails(int id) {

        String customer = repository.findCustomerById(id);

        System.out.println("\nCustomer Details");
        System.out.println("----------------");
        System.out.println("Customer ID : " + id);
        System.out.println("Customer Name : " + customer);

    }

}