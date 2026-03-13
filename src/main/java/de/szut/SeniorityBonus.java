package de.szut;

public class SeniorityBonus extends BonusDecorator {

    private int intervalYears;
    private double bonusPerInterval;

    public SeniorityBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        return 0;
    }
}
