import java.util.Scanner;

public class ObserverTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockMarket stockMarket = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        stockMarket.registerObserver(mobile);
        stockMarket.registerObserver(web);

        System.out.println("\nEnter Stock Name:");
        String stockName = sc.nextLine();

        System.out.println("Enter Stock Price:");
        double stockPrice = sc.nextDouble();

        stockMarket.setStock(stockName, stockPrice);

        sc.close();

    }

}