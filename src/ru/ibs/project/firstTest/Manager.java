package ru.ibs.project.firstTest;

public interface Manager {
    int coefficientManager = 3; //public, static и final

    String teamInfo();

    String employeeInfo(Employee employee);

    default void changePayment(Employee employee, double payment) {
        employee.setPayment(payment);
    }
}
