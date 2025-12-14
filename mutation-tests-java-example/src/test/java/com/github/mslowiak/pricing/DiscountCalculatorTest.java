package com.github.mslowiak.pricing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculator();
    }

    @Test
    void shouldThrowExceptionForNonPositivePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateFinalPrice(0, "bronze", 1, false));
    }

    @Test
    void shouldApplyBronzeTierDiscount() {
        double result = calculator.calculateFinalPrice(100, "bronze", 1, false);
        assertEquals(95.0, result, 0.01); // 5% off
    }

    @Test
    void shouldApplyGoldTierDiscount() {
        double result = calculator.calculateFinalPrice(100, "gold", 1, false);
        assertEquals(85.0, result, 0.01); // 15% off
    }

    @Test
    void shouldApplyBulkDiscount() {
        double result = calculator.calculateFinalPrice(100, "bronze", 10, false);
        assertEquals(90.0, result, 0.01); // 5% tier + 5% bulk = 10% total
    }

    @Test
    void shouldHandleUnknownTier() {
        double result = calculator.calculateFinalPrice(100, "unknown", 1, false);
        assertEquals(100.0, result, 0.01); // no discount
    }
}