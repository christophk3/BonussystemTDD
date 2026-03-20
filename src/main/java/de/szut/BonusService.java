package de.szut;

public class BonusService {

    private double maxBonus;
    private double minBonus;

    public BonusService(double minBonus, double maxBonus) {
        this.minBonus = minBonus;
        this.maxBonus = maxBonus;
    }

    public double applyRestrictions(double bonus) {
        if (bonus < minBonus) {
            return minBonus;
        }
        if (bonus > maxBonus) {
            return maxBonus;
        }
        return bonus;
    }



}
