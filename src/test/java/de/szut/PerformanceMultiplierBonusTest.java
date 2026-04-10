package de.szut;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerformanceMultiplierBonusTest {

    private BonusComponent mockedBonusComponent;
    private PerformanceMultiplierBonus performanceMultiplierBonus;
    private Employee employee;

    @BeforeEach
    void setUp() {
        mockedBonusComponent = mock(BonusComponent.class);
        performanceMultiplierBonus = new PerformanceMultiplierBonus(mockedBonusComponent);
        employee = new Employee("Max Mustermann", 0, 0, 0, 0, false);
    }

    @Test
    void givenEmployeeWithLowPerformance_calculateBonusWithFactorOne() {
        employee.setPerformanceRating(20);
        when(mockedBonusComponent.calculateBonus(employee)).thenReturn(100.0);
        double result = performanceMultiplierBonus.calculateBonus(employee);
        assertEquals(100.0, result);
    }
}