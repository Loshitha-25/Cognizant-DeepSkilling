public class FinancialForecast {

    private double currentValue;
    private double growthRate;
    private int years;

    public FinancialForecast(double currentValue, double growthRate, int years) {
        this.currentValue = currentValue;
        this.growthRate = growthRate;
        this.years = years;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public int getYears() {
        return years;
    }
}