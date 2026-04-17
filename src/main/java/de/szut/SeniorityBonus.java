package de.szut;

public class SeniorityBonus extends BonusDecorator {

    private final int intervalYears;
    private final double bonusPerInterval;

    public SeniorityBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
        intervalYears = 5;
        bonusPerInterval = 100;
    }

    @Override
    public double calculateBonus(Employee employee) {
        int yearsAtCompany = employee.getYearsAtCompany();
        int bonusTimes = yearsAtCompany / intervalYears;
        return bonusComponent.calculateBonus(employee) + bonusTimes * bonusPerInterval;
    }


}
