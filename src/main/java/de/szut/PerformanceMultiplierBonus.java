package de.szut;

public class PerformanceMultiplierBonus extends BonusDecorator {

    private BonusComponent bonusComponent;
    private static final double LOW_MULTIPLICATION_FACTOR = 1.0;
    private static final int MAX_LOW_PERFORMANCE = 30;

    public PerformanceMultiplierBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
        this.bonusComponent = bonusComponent;
    }

    @Override
    public double calculateBonus(Employee employee) {
        double baseBonus = bonusComponent.calculateBonus(employee);
        if (employee.getPerformanceRating() <= MAX_LOW_PERFORMANCE) {
            return baseBonus * LOW_MULTIPLICATION_FACTOR;
        }
        return baseBonus;
    }
}