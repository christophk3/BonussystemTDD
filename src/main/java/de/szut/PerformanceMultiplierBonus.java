package de.szut;

public class PerformanceMultiplierBonus extends BonusDecorator {

    private static final double LOW_MULTIPLICATION_FACTOR = 1.0;
    private static final double MID_MULTIPLICATION_FACTOR = 1.2;
    private static final double HIGH_MULTIPLICATION_FACTOR = 1.5;
    private static final int MAX_LOW_PERFORMANCE = 30;
    private static final int MAX_MID_PERFORMANCE = 70;

    public PerformanceMultiplierBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        double baseBonus = bonusComponent.calculateBonus(employee);
        if (employee.getPerformanceRating() <= MAX_LOW_PERFORMANCE) {
            return baseBonus * LOW_MULTIPLICATION_FACTOR;
        }
        if (employee.getPerformanceRating() <= MAX_MID_PERFORMANCE) {
            return baseBonus * MID_MULTIPLICATION_FACTOR;
        }
        return baseBonus * HIGH_MULTIPLICATION_FACTOR;
    }
}