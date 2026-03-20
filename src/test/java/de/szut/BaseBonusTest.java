package de.szut;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBonusTest {

    @Test
    void calculateBonus_returnsZero() {
        BaseBonus baseBonus = new BaseBonus();
        Employee employee = new Employee("John", 0, 0, 0, 0, false);

        double result = baseBonus.calculateBonus(employee);

        assertThat(result).isEqualTo(0.0);
    }
}
