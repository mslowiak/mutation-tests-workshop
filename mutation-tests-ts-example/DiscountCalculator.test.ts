import { DiscountCalculator } from './DiscountCalculator';

describe('DiscountCalculator', () => {
    let calculator: DiscountCalculator;

    beforeEach(() => {
        calculator = new DiscountCalculator();
    });

    test('should throw error for non-positive price', () => {
        expect(() => calculator.calculateFinalPrice(0, 'bronze', 1, false))
            .toThrow('Base price must be positive');
    });

    test('should apply bronze tier discount', () => {
        const result = calculator.calculateFinalPrice(100, 'bronze', 1, false);
        expect(result).toBe(95); // 5% off
    });

    test('should apply gold tier discount', () => {
        const result = calculator.calculateFinalPrice(100, 'gold', 1, false);
        expect(result).toBe(85); // 15% off
    });

    test('should apply bulk discount', () => {
        const result = calculator.calculateFinalPrice(100, 'bronze', 10, false);
        expect(result).toBe(90); // 5% tier + 5% bulk = 10% total
    });

    test('should handle unknown tier', () => {
        const result = calculator.calculateFinalPrice(100, 'unknown', 1, false);
        expect(result).toBe(100); // no discount
    });
});