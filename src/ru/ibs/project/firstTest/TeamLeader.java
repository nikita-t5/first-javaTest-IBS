package ru.ibs.project.firstTest;

import java.util.List;
import java.util.Objects;

public class TeamLeader extends Employee implements Manager {
    private List<Employee> employees;
    private String project;

    public TeamLeader(String name, double payment, int worktime, List<Employee> employees, String project) {
        super(name, payment, worktime);
        this.employees = employees;
        this.project = project;
    }

    @Override
    public double calcSalary() {
        return worktime * payment * coefficientManager;
    }

    @Override
    public String teamInfo() {
        StringBuffer sb = new StringBuffer();
        for (Employee employee : employees) {
            sb.append(employee.getName()).append(" ");

        }
        return "Моя команда: " + sb +
                ". Наш проект: " + project;
    }

    @Override
    public String employeeInfo(Employee employee) {
        if (employees.contains(employee)) {
            return employee.getName() + " это мой сотрудник. Его зарплата: " + employee.calcSalary();
        } else
            return "У меня сотрудника " + employee.getName();
    }

    public int checkWorktimeEmpl(Employee employee) {
        return employee.getWorktime();
    }

    //getters and setters
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    //hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeamLeader that = (TeamLeader) o;
        return Objects.equals(employees, that.employees) &&
                project.equals(that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employees, project);
    }

}
