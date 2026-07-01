import java.util.HashMap;

public class InventoryManagement {

    private HashMap<Integer, Product> inventory = new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        if (inventory.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists.");
            return;
        }

        inventory.put(product.getProductId(), product);
        System.out.println("Product Added Successfully.");
    }

    // View Products
    public void displayProducts() {

        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-8s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Qty", "Price", "Category");
        System.out.println("--------------------------------------------------------------");

        for (Product p : inventory.values()) {

            System.out.printf("%-8d %-15s %-10d %-10.2f %-15s%n",
                    p.getProductId(),
                    p.getProductName(),
                    p.getQuantity(),
                    p.getPrice(),
                    p.getCategory());

        }
    }

    // Search Product
    public void searchProduct(int id) {

        Product p = inventory.get(id);

        if (p == null) {

            System.out.println("Product Not Found.");

            return;

        }

        System.out.println("\nProduct Found");

        System.out.println("ID : " + p.getProductId());

        System.out.println("Name : " + p.getProductName());

        System.out.println("Quantity : " + p.getQuantity());

        System.out.println("Price : ₹" + p.getPrice());

        System.out.println("Category : " + p.getCategory());

    }

    // Update Product
    public void updateProduct(int id, String name, int qty, double price, String category) {

        Product p = inventory.get(id);

        if (p == null) {

            System.out.println("Product Not Found.");

            return;

        }

        p.setProductName(name);

        p.setQuantity(qty);

        p.setPrice(price);

        p.setCategory(category);

        System.out.println("Product Updated Successfully.");

    }

    // Delete Product
    public void deleteProduct(int id) {

        if (inventory.remove(id) != null)

            System.out.println("Product Deleted Successfully.");

        else

            System.out.println("Product Not Found.");

    }

    // Inventory Value
    public void totalInventoryValue() {

        double total = 0;

        for (Product p : inventory.values()) {

            total += p.getPrice() * p.getQuantity();

        }

        System.out.println("Total Inventory Value = ₹" + total);

    }

}