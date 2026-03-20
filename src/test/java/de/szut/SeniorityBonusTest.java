package de.szut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeniorityBonusTest {

    Employee employee;
    SeniorityBonus seniorityBonus;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", 0, 0, 0, 0, false);
        BonusComponent baseBonus = mock(BonusComponent.class);
        seniorityBonus = new SeniorityBonus(baseBonus);
    }

    @Test
    void testCalculateBonus_employeeFiveYearsAtCompany_bonusIs100() {
        employee.setYearsAtCompany(5);

        double bonusAmount = seniorityBonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(100);
    }

    @Test
    void testCalculateBonus_employeeOneYearAtCompany_NoBonus() {
        employee.setYearsAtCompany(1);

        double bonusAmount = seniorityBonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(0);
    }
}