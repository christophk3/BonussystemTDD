package de.szut;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProjectCompletionBonusTest {

    private BonusComponent mockedBonusComponent;
    private ProjectCompletionBonus projectCompletionBonus;

    private Employee employeeWithProject;
    @BeforeEach
    void setUp() {
        mockedBonusComponent = mock(BonusComponent.class);
        projectCompletionBonus = new ProjectCompletionBonus(mockedBonusComponent);
        employeeWithProject = new Employee("Max Mustermann", 0, 0, 0, 0, false);
    }

    @Test
    void givenEmployeeWithOneCompletedProject_calculateBonus() {
        employeeWithProject.setCompletedProjects(1);
        double result = projectCompletionBonus.calculateBonus(employeeWithProject);
        assertEquals(200.0, result);
    }
}