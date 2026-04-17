package de.szut;

public class BonusCalculator {

    private BonusComponent bonusComponent;

    public BonusCalculator() {
        this.bonusComponent = new BaseBonus();
    }

    public void calculateSeniorityBonus() {
        this.bonusComponent = new SeniorityBonus(this.bonusComponent);
    }

    public double calculateBonus(Employee employee) {
        return bonusComponent.calculateBonus(employee);
    }
}