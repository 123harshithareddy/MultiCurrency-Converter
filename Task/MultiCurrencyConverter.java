package Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultiCurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("INR", 1.0); // Indian Rupee (Base Currency)
        exchangeRates.put("USD", 0.012); // 1 INR = 0.012 USD
        exchangeRates.put("EUR", 0.011); // 1 INR = 0.011 EUR
        exchangeRates.put("GBP", 0.0095); // 1 INR = 0.0095 GBP
        exchangeRates.put("JPY", 1.7); // 1 INR = 1.7 JPY
        exchangeRates.put("AUD", 0.018); // 1 INR = 0.018 AUD
        exchangeRates.put("CAD", 0.016); // 1 INR = 0.016 CAD
        exchangeRates.put("CHF", 0.011); // 1 INR = 0.011 CHF
        exchangeRates.put("CNY", 0.084); // 1 INR = 0.084 CNY
        exchangeRates.put("NZD", 0.019); // 1 INR = 0.019 NZD
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., INR, USD, EUR, GBP, JPY, AUD, CAD, CHF, CNY, NZD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter target currency (e.g., INR, USD, EUR, GBP, JPY, AUD, CAD, CHF, CNY, NZD): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        if (!exchangeRates.containsKey(baseCurrency) || !exchangeRates.containsKey(targetCurrency)
                || baseCurrency.equals(targetCurrency)) {
            System.out.println("Invalid or identical currency codes. Please use supported currency codes.");
            scanner.close();
            return;
        }

        System.out.print("Enter amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        double convertedAmount = convertCurrency(amount, baseCurrency, targetCurrency);

        // Display result
        System.out.printf("Converted amount: %.2f %s\n", convertedAmount, targetCurrency);

        scanner.close();
    }

    // Method to convert currency
    private static double convertCurrency(double amount, String baseCurrency, String targetCurrency) {
        double baseToInr = exchangeRates.get(baseCurrency);
        double targetToInr = exchangeRates.get(targetCurrency);
        return amount * (targetToInr / baseToInr);
    }
}
