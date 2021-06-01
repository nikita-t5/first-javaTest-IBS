package firstTest;

import java.util.Objects;

public class Intern extends Employee {
    private String university;
    private int daysAtWork;
    private static final int levelPromotion = 100;

    public Intern(String name, double payment, int worktime, String university, int daysAtWork) {
        super(name, payment, worktime);
        this.university = university;
        this.daysAtWork = daysAtWork;
    }

    @Override
    public double calcSalary() {
        return worktime * payment;
    }

    public String checkWorkExperience() {
        if (daysAtWork > levelPromotion)
            return name + " можно перевести на должность Developer";
        else
            return name + " необходимо отработать еще " + (levelPromotion - daysAtWork);
    }

    public String sayAboutUniversity() {
        return "Меня зовут " + name +
                " я учусь в " + university +
                " еще я работаю уже " + daysAtWork +
                " дней";
    }

    public void increaseAnotherDay() {
        daysAtWork++;
    }

    //getters and setters
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getDaysAtWork() {
        return daysAtWork;
    }

    public void setDaysAtWork(int daysAtWork) {
        this.daysAtWork = daysAtWork;
    }

    public static int getLevelPromotion() {
        return levelPromotion;
    }

    //hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Intern intern = (Intern) o;
        return daysAtWork == intern.daysAtWork &&
                university.equals(intern.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, daysAtWork);
    }
}
