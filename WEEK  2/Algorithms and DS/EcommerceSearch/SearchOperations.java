import java.util.Arrays;
import java.util.Comparator;

public class SearchOperations {

    // Linear Search

    public static Product linearSearch(Product[] products, int id) {

        for (Product product : products) {

            if (product.getProductId() == id)

                return product;

        }

        return null;

    }

    // Binary Search

    public static Product binarySearch(Product[] products, int id) {

        int left = 0;

        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (products[mid].getProductId() == id)

                return products[mid];

            else if (products[mid].getProductId() < id)

                left = mid + 1;

            else

                right = mid - 1;

        }

        return null;

    }

    // Sorting for Binary Search

    public static void sortProducts(Product[] products) {

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

    }

}