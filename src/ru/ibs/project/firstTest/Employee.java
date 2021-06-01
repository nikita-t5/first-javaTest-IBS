package ru.ibs.project.firstTest;

import java.util.Objects;

public abstract class Employee {
    protected String name;
    protected double payment;
    protected int worktime;

    public Employee(String name, double payment, int worktime) {
        this.name = name;
        this.payment = payment;
        this.worktime = worktime;
    }

    public abstract double calcSalary();

    public String aboutEmployee() {
        return "Имя: " + name +
                ". Должность: " + this.getClass().getSimpleName() +
                ". Ставка: " + payment +
                ". Отработано времени: " + worktime +
                ". Зарплата: " + calcSalary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.payment, payment) == 0 &&
                worktime == employee.worktime &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, payment, worktime);
    }
}
