package de.szut;

public class TeamLeaderBonus extends BonusDecorator {

    private final double teamLeaderBonus;

    public TeamLeaderBonus(BonusComponent component, double teamLeaderBonus) {
        super(component);
        this.teamLeaderBonus = teamLeaderBonus;
    }

    @Override
    public double calculateBonus(Employee employee) {
        if (employee.isTeamLeader()) {
            return teamLeaderBonus;
        }
        return 0.0;
    }


}
