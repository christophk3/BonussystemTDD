package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusCalculatorTest {

    private BonusCalculator bonusCalculator;
    private Employee employee;

    @BeforeEach
    void setUp() {
        BonusService bonusService = new BonusService(-500, 1000);
        bonusCalculator = new BonusCalculator(bonusService);
        employee = new Employee("Max Mustermann", 0, 0, 0, 0, false);
    }

    @Test
    void calculateTotalBonus_newEmployee_returnsLowAbsenceBonus() {
        assertThat(bonusCalculator.calculateTotalBonus(employee)).isEqualTo(300.0);
    }

    @Test
    void calculateTotalBonus_seniorityFiveYears_returnsSeniorityPlusLowAbsence() {
        employee.setYearsAtCompany(5);
        assertThat(bonusCalculator.calculateTotalBonus(employee)).isEqualTo(400.0);
    }

    @Test
    void calculateTotalBonus_bonusExceedsMax_returnsMax() {
        employee.setYearsAtCompany(100);
        assertThat(bonusCalculator.calculateTotalBonus(employee)).isEqualTo(1000.0);
    }

}
