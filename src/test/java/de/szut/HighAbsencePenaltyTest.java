package de.szut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    void calculateBonus_employeeHas25Absence_noPenalty() {
        employee.setAbsentDays(25);  // war: 30

        double bonusAmount = penalty.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(0);
    }


    @Test
    void calculateBonus_employeeHas35Absence_tierOnePenalty() {
        employee.setAbsentDays(35);

        double bonusAmount = penalty.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(-100);
    }

    @Test
    void calculateBonus_employeeHas45Absence_tierTwoPenalty() {
        employee.setAbsentDays(45);

        double bonusAmount = penalty.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(-300);
    }

    @ParameterizedTest
    @MethodSource("calculateBonusArguments")
    void calculateBonus(int absentDays, int expectedBonus) {
        employee.setAbsentDays(absentDays);

        double bonusAmount = penalty.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(expectedBonus);
    }

    private static Stream<Arguments> calculateBonusArguments() {
        return Stream.of(
                Arguments.of(25, 0),
                Arguments.of(29, 0),
                Arguments.of(30, -100),
                Arguments.of(31, -100),
                Arguments.of(35, -100),
                Arguments.of(39, -100),
                Arguments.of(40, -300),
                Arguments.of(41, -300),
                Arguments.of(45, -300)
        );
    }
    @Test
    void shouldAddInnerBonusToHighAbsencePenalty() {
        employee.setAbsentDays(35);

        BonusComponent innerBonus = mock(BonusComponent.class);
        org.mockito.Mockito.when(innerBonus.calculateBonus(employee)).thenReturn(500.0);

        HighAbsencePenalty penalty = new HighAbsencePenalty(innerBonus);

        assertThat(penalty.calculateBonus(employee)).isEqualTo(400.0);
    }

}