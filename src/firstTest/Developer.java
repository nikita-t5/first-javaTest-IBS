package firstTest;

import java.util.Objects;

public class Developer extends Employee {
    private double bonus;
    private Intern intern;
    private String task;

    public Developer(String name, double payment, int worktime, double bonus, Intern intern, String task) {
        super(name, payment, worktime);
        this.bonus = bonus;
        this.intern = intern;
        this.task = task;
    }

    @Override
    public double calcSalary() {
        return worktime * payment * bonus;
    }


    public String askIntern() {
        return intern.getName() +
                " помоги мне " + task;
    }

    public String sayResume() {
        return "Мое имя: " + name +
                ". Моя задача: " + task +
                ". Моя зарплата: " + calcSalary() +
                ". Мой бонус сейчас: " + bonus;
    }

    //getters and setters
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    //hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return Double.compare(developer.bonus, bonus) == 0 &&
                intern.equals(developer.intern) &&
                task.equals(developer.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus, intern, task);
    }
}
