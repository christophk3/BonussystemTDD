package de.szut;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @ParameterizedTest
    @MethodSource("calculateBonusArguments")
    void testCalculateBonus(int yearsAtCompany, int expectedBonus) {
        employee.setYearsAtCompany(yearsAtCompany);

        double bonusAmount = seniorityBonus.calculateBonus(employee);

        assertThat(bonusAmount).isEqualTo(expectedBonus);
    }

    private static Stream<Arguments> calculateBonusArguments() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(4, 0),
                Arguments.of(5, 100),
                Arguments.of(10, 200),
                Arguments.of(12, 200),
                Arguments.of(15, 300)
        );
    }
}