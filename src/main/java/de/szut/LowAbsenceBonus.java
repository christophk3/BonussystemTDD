package de.szut;

public class LowAbsenceBonus extends BonusDecorator {

    private final int tierOneLimit;
    private final int tierOneBonus;
    private final int tierTwoLimit;
    private final double tierTwoBonus;

    public LowAbsenceBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
        tierOneLimit = 20;
        tierTwoLimit = 10;
        tierOneBonus = 100;
        tierTwoBonus = 300;
    }

    @Override
    public double calculateBonus(Employee employee) {
        if(employee.getAbsentDays() <= tierTwoLimit) {
            return tierTwoBonus;
        } else if(employee.getAbsentDays() <= tierOneLimit) {
            return tierOneBonus;
        } else {
            return 0;
        }
    }
}
