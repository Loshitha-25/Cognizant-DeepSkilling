import java.util.Scanner;

public class ForecastTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" FINANCIAL FORECASTING SYSTEM ");
        System.out.println("=================================");

        System.out.print("Enter Present Value : ");

        double presentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%) : ");

        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years : ");

        int years = sc.nextInt();

        double future = FinancialForecast.futureValue(

                presentValue,

                growthRate / 100,

                years

        );

        System.out.printf("\nFuture Value after %d years = ₹%.2f",

                years,

                future);

        sc.close();

    }

}