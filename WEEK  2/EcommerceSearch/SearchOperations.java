import java.util.Arrays;
import java.util.Comparator;

public class SearchOperations {

    // Product Database
    static Product[] products = {

            new Product(101,"Laptop","Electronics"),
            new Product(102,"Keyboard","Accessories"),
            new Product(103,"Mouse","Accessories"),
            new Product(104,"Monitor","Electronics"),
            new Product(105,"Printer","Electronics")

    };

    // -------------------------
    // Linear Search
    // -------------------------

    public static Product linearSearchByName(String name){

        for(Product product : products){

            if(product.getProductName().equalsIgnoreCase(name)){

                return product;

            }

        }

        return null;

    }

    // -------------------------
    // Binary Search
    // -------------------------

    public static Product binarySearchByName(String name){

        Arrays.sort(products,
                Comparator.comparing(Product::getProductName));

        int left = 0;
        int right = products.length-1;

        while(left<=right){

            int mid = (left+right)/2;

            int result = products[mid]
                    .getProductName()
                    .compareToIgnoreCase(name);

            if(result==0){

                return products[mid];

            }

            else if(result<0){

                left = mid+1;

            }

            else{

                right = mid-1;

            }

        }

        return null;

    }

    // -------------------------
    // Display Result
    // -------------------------

    public static void display(Product product){

        if(product!=null){

            System.out.println(product);

        }

        else{

            System.out.println("Product Not Found.");

        }

    }

    public static void main(String[] args) {

        System.out.println("========== LINEAR SEARCH ==========");

        display(linearSearchByName("Mouse"));

        System.out.println();

        System.out.println("========== BINARY SEARCH ==========");

        display(binarySearchByName("Mouse"));

    }

}