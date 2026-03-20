package de.szut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LowAbsenceBonusTest {

    Employee employee;
    LowAbsenceBonus bonus;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", 0, 0, 0, 0, false);
        BonusComponent component = mock(BonusComponent.class);
        bonus = new LowAbsenceBonus(component);
    }

    @Test
    void calculateBonus_employeeHas0Absence_TierTwoBonusIsApplied() {
        employee.setAbsentDays(0);

        double bonusAmount = bonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(300);
    }

    @Test
    void calculateBonus_employeeHas15Absence_TierOneBonusIsApplied() {
        employee.setAbsentDays(15);

        double bonusAmount = bonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(100);
    }

    @Test
    void calculateBonus_employeeHas50Absence_NoBonusApplied() {
        employee.setAbsentDays(50);

        double bonusAmount = bonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(0);

    }
}