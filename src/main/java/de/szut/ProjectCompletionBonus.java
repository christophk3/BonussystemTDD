package de.szut;

public class ProjectCompletionBonus extends BonusDecorator {

    public ProjectCompletionBonus(BonusComponent bonusComponent) {
        super(bonusComponent);
    }

    @Override
    public double calculateBonus(Employee employee) {
        return bonusComponent.calculateBonus(employee) + employee.getCompletedProjects() * 10.0;
    }

}
