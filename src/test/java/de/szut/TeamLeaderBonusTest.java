package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class TeamLeaderBonusTest {

    Employee employee;
    TeamLeaderBonus teamLeaderBonus;

    @BeforeEach
    void setUp() {
        employee = new Employee("John Doe", 0, 0, 0, 0, false);
        BonusComponent inner = mock(BonusComponent.class);
        teamLeaderBonus = new TeamLeaderBonus(inner, 300.0);
    }

    @Test
    void calculateBonus_addsTeamLeaderBonus_whenEmployeeIsTeamLeader() {
        employee.setTeamLeader(true);

        double result = teamLeaderBonus.calculateBonus(employee);

        assertThat(result).isEqualTo(300.0);
    }
}
