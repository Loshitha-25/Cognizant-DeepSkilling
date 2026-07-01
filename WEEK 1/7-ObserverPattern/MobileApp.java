public class MobileApp implements Observer {

    @Override
    public void update(String stockName, double stockPrice) {

        System.out.println("Mobile App Notification");
        System.out.println(stockName + " price updated to Rs." + stockPrice);

    }

}