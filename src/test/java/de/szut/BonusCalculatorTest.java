package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusCalculatorTest {

    private BonusCalculator bonusCalculator;
    private Employee employee;

    @BeforeEach
    void setUp() {
        bonusCalculator = new BonusCalculator();
        employee = new Employee("Max Mustermann", 0, 0, 0, 0, false);
    }

    @Test
    void calculateBonus_withBaseBonus_returnsZero() {
        double result = bonusCalculator.calculateBonus(employee);

        assertThat(result).isEqualTo(0.0);
    }
}
