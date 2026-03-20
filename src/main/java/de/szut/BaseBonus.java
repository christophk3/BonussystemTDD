package de.szut;

public class BaseBonus implements BonusComponent {

    @Override
    public double calculateBonus(Employee employee) {
        return 0.0;
    }
}