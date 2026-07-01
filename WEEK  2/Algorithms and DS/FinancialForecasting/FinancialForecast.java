public class FinancialForecast {

    // Recursive Method
    public static double futureValue(double presentValue,
                                     double growthRate,
                                     int years) {

        // Base Case
        if (years == 0) {

            return presentValue;

        }

        // Recursive Case
        return futureValue(
                presentValue * (1 + growthRate),
                growthRate,
                years - 1
        );

    }

}