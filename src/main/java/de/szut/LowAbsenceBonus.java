package de.szut;

public class LowAbsenceBonus extends BonusDecorator {

    private int tierOneLimit;
    private int tierOneBonus;
    private int tierTwoLimit;
    private double tierTwoBonus;

    public LowAbsenceBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
        tierOneLimit = 20;
        tierTwoLimit = 10;
        tierOneBonus = 100;
        tierTwoBonus = 300;
    }

    @Override
    public double calculateBonus(Employee employee) {
        return tierTwoBonus;
    }
}
