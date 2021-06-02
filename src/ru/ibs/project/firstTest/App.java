package ru.ibs.project.firstTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Employee petya = new Intern("Петя", 200, 80, "МГУ", 55);
        Employee misha = new Intern("Миша", 180, 70, "МГУ", 20);
        Employee dasha = new Intern("Даша", 230, 75, "НГТУ", 200);
        Employee sasha = new Intern("Саша", 210, 100, "СПБГУ", 160);
        Employee vasya = new Developer("Вася", 450.0, 160, 1.1, (Intern) petya, "Написать микросервис");
        Employee sam = new Developer("Семен", 400.0, 140, 1.15, (Intern) misha, "Тестировать код");
        Employee oleg = new Developer("Олег", 550.0, 190, 1.2, (Intern) dasha, "Написать БД");
        Employee roma = new Developer("Рома", 300.0, 150, 1.02, (Intern) sasha, "Делать новые фичи");

        List<Employee> teamList = new ArrayList<>();
        teamList.add(petya);
        teamList.add(misha);
        teamList.add(dasha);
        teamList.add(sasha);
        teamList.add(vasya);
        teamList.add(sam);
        teamList.add(oleg);
        teamList.add(roma);

        Employee ivan = new TeamLeader("Иван", 600, 200, teamList, "ABC");

        //homework #1 2.a)
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(petya);
        employeeSet.add(vasya);
        employeeSet.add(ivan);

        //homework #1 2.b)
        List<Employee> employeeList = new ArrayList<>(employeeSet);

        for (Employee employee : employeeList)
            System.out.println(employee.getClass().getSimpleName() + " " +
                    employee.getName() + ". Зарплата: " + employee.calcSalary());


        //homework #2 1.
        var freshEmployee = new Employee() {
            private double yearsWorkExperience;
            private double desiredPayment;

            @Override
            public double calcSalary() {
                double startBonus = 480;
                return payment * startBonus;
            }

            public String salaryDecision() {
                if ((desiredPayment > 500.0) || (yearsWorkExperience < 1.0))
                    return "Сотрудник не подходит";
                else {
                    payment = desiredPayment;
                    return "Сотрудник принят, его ставка " + payment + " р/час";
                }
            }

            public String managerDecision(Employee employee) {
                return "Менеджер для сотрудника будет " + employee.getName();
            }

            //getters and setters
            public double getYearsWorkExperience() {
                return yearsWorkExperience;
            }

            public void setYearsWorkExperience(double yearsWorkExperience) {
                this.yearsWorkExperience = yearsWorkExperience;
            }

            public double getDesiredPayment() {
                return desiredPayment;
            }

            public void setDesiredPayment(double desiredPayment) {
                this.desiredPayment = desiredPayment;
            }
        };

        //homework #2 2.a)
        List<Employee> employees = new ArrayList<>(teamList);
        employees.add(ivan);

        //homework #2 2.b)
        List<Employee> mostExpensiveEmployees = employees
                .stream()
                .filter(e -> e.getPayment() > 400.0)
                .collect(Collectors.toList());

        //homework #2 2.c)
        mostExpensiveEmployees
                .stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
