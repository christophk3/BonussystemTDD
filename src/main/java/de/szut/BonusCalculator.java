package de.szut;

public class BonusCalculator {

    private final BonusService bonusService;

    public BonusCalculator(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    public double calculateTotalBonus(Employee employee) {
        BonusComponent bonus = new BaseBonus();
        bonus = new SeniorityBonus(bonus);
        bonus = new ProjectCompletionBonus(bonus);
        bonus = new TeamLeaderBonus(bonus, 300);
        bonus = new LowAbsenceBonus(bonus);
        bonus = new HighAbsencePenalty(bonus);
        bonus = new PerformanceMultiplierBonus(bonus);

        return bonusService.applyRestrictions(bonus.calculateBonus(employee));
    }
}
