package de.szut;

public abstract class BonusDecorator implements BonusComponent {

    protected BonusComponent bonusComponent;

    public BonusDecorator(BonusComponent bonusComponent) {
        this.bonusComponent = bonusComponent;
    }

    @Override
    public abstract double calculateBonus(Employee employee);
}
