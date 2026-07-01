import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();

    private String stockName;
    private double stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Observer Registered Successfully.");
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer Removed Successfully.");
    }

    @Override
    public void notifyObservers() {

        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }

    }

    public void setStock(String stockName, double stockPrice) {

        this.stockName = stockName;
        this.stockPrice = stockPrice;

        System.out.println("\nStock Updated");
        System.out.println("Stock Name : " + stockName);
        System.out.println("Stock Price : Rs." + stockPrice);

        notifyObservers();
    }

}