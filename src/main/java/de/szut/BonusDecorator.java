package de.szut;

public abstract class BonusDecorator {

    private BonusComponent bonusComponent;

    public BonusDecorator(BonusComponent bonusComponent) {
        this.bonusComponent = bonusComponent;
    }

    public abstract double calculateBonus(Employee employee);
}
