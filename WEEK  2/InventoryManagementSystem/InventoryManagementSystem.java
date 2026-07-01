import java.util.HashMap;

public class InventoryManagementSystem {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        inventory.put(product.getProductId(), product);

        System.out.println("Product Added Successfully.\n");
    }

    // Update Product
    public void updateProduct(int id, String name, int quantity, double price) {

        Product product = inventory.get(id);

        if(product != null){

            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println("Product Updated Successfully.\n");

        }else{

            System.out.println("Product Not Found.\n");

        }

    }

    // Delete Product
    public void deleteProduct(int id){

        if(inventory.remove(id)!=null){

            System.out.println("Product Deleted Successfully.\n");

        }else{

            System.out.println("Product Not Found.\n");

        }

    }

    // Display Products
    public void displayProducts(){

        System.out.println("----------- Inventory -----------");

        for(Product product : inventory.values()){

            System.out.println(product);

            System.out.println("-----------------------------");

        }

    }

    public static void main(String[] args) {

        InventoryManagementSystem ims = new InventoryManagementSystem();

        ims.addProduct(new Product(101,"Laptop",10,50000));

        ims.addProduct(new Product(102,"Keyboard",20,1200));

        ims.addProduct(new Product(103,"Mouse",30,800));

        ims.displayProducts();

        ims.updateProduct(102,"Mechanical Keyboard",25,1800);

        ims.displayProducts();

        ims.deleteProduct(101);

        ims.displayProducts();

    }

}