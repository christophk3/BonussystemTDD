package de.szut;

public class HighAbsencePenalty extends BonusDecorator {

    private int tierOneLimit;
    private double tierOneValue;
    private int tierTwoLimit;
    private double tierTwoValue;

    public HighAbsencePenalty(BonusComponent bonusComponent) {
        super(bonusComponent);
        tierOneLimit = 30;
        tierTwoLimit = 40;
        tierOneValue = -100;
        tierTwoValue = -300;
    }

    @Override
    public double calculateBonus(Employee employee) {
        if(employee.getAbsentDays() > tierOneLimit) {
            return tierOneValue;
        } else {
            return 0;
        }
    }
}
