import java.util.Scanner;

public class FinancialForecastingSystem {

    // Recursive Method
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {

        if (years == 0) {
            return currentValue;
        }

        return calculateFutureValue(currentValue * (1 + growthRate / 100), growthRate, years - 1);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========== Financial Forecasting ==========");

        System.out.print("Enter Current Value : ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%) : ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter Number of Years : ");
        int years = sc.nextInt();

        FinancialForecast forecast =
                new FinancialForecast(currentValue, growthRate, years);

        double futureValue = calculateFutureValue(
                forecast.getCurrentValue(),
                forecast.getGrowthRate(),
                forecast.getYears());

        System.out.println("\n========== Forecast Result ==========");

        System.out.printf("Current Value : ₹%.2f%n", forecast.getCurrentValue());
        System.out.printf("Growth Rate   : %.2f%%%n", forecast.getGrowthRate());
        System.out.println("Years         : " + forecast.getYears());
        System.out.printf("Future Value  : ₹%.2f%n", futureValue);

        sc.close();

    }

}