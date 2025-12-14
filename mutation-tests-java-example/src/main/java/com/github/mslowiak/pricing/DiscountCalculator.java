package com.github.mslowiak.pricing;

public class DiscountCalculator {

    /**
     * Calculates the final price after applying various discounts
     * @param basePrice The original price
     * @param customerTier bronze, silver, gold, or platinum
     * @param itemCount Number of items being purchased
     * @param isHolidaySale Whether holiday sale is active
     * @return Final price after discounts
     */
    public double calculateFinalPrice(double basePrice, String customerTier,
                                      int itemCount, boolean isHolidaySale) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive");
        }

        double discount = 0.0;

        // Tier-based discount
        switch (customerTier.toLowerCase()) {
            case "bronze":
                discount = 0.05;
                break;
            case "silver":
                discount = 0.10;
                break;
            case "gold":
                discount = 0.15;
                break;
            case "platinum":
                discount = 0.20;
                break;
            default:
                discount = 0.0;
        }

        // Bulk discount (additional)
        if (itemCount >= 10) {
            discount += 0.05;
        }

        // Holiday sale (additional)
        if (isHolidaySale) {
            discount += 0.10;
        }

        // Cap total discount at 35%
        if (discount > 0.35) {
            discount = 0.35;
        }

        double finalPrice = basePrice * (1 - discount);

        // Minimum price enforcement
        return finalPrice < 10 ? 10 : finalPrice;
    }
}