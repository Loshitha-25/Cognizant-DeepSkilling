public class WebApp implements Observer {

    @Override
    public void update(String stockName, double stockPrice) {

        System.out.println("Web App Notification");
        System.out.println(stockName + " price updated to Rs." + stockPrice);

    }

}