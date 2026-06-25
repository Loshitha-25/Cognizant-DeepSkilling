public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public String findCustomerById(int id) {

        switch(id) {

            case 101:
                return "Loshitha";

            case 102:
                return "Rahul";

            case 103:
                return "Priya";

            default:
                return "Customer Not Found";
        }

    }

}