package de.szut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HighAbsencePenaltyTest {

    Employee employee;
    HighAbsencePenalty penalty;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", 0, 0, 0, 0, false);
        BonusComponent component = mock(BonusComponent.class);
        penalty = new HighAbsencePenalty(component);
    }


    @Test
    void calculateBonus_employeeHas30Absence_noPenalty() {
        employee.setAbsentDays(30);

        double bonusAmount = penalty.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(0);
    }
}