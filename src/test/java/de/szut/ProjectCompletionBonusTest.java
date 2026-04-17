package de.szut;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


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
        assertEquals(10.0, result);
    }

    @Test
    void givenEmployeeWithTwoCompletedProject_calculateBonus() {
        employeeWithProject.setCompletedProjects(2);
        double result = projectCompletionBonus.calculateBonus(employeeWithProject);
        assertEquals(20.0, result);
    }

    @Test
    void givenEmployeeWithZeroCompletedProjects_calculateBonusIsZero() {
        employeeWithProject.setCompletedProjects(0);
        double result = projectCompletionBonus.calculateBonus(employeeWithProject);
        assertEquals(0.0, result);
    }

    @Test
    void shouldAddInnerBonusToProjectCompletionBonus() {
        employeeWithProject.setCompletedProjects(3);

        BonusComponent innerBonus = mock(BonusComponent.class);
        org.mockito.Mockito.when(innerBonus.calculateBonus(employeeWithProject)).thenReturn(100.0);

        ProjectCompletionBonus projectBonus = new ProjectCompletionBonus(innerBonus);

        assertThat(projectBonus.calculateBonus(employeeWithProject)).isEqualTo(130.0);
    }

}