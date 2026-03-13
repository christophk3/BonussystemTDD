package de.szut;

public class ProjectCompletionBonus extends BonusDecorator {

    public ProjectCompletionBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        return 0;
    }
}
