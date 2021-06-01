package firstTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Employee petya = new Intern("Петя", 200, 80, "МГУ", 55);
        Employee vasya = new Developer("Вася", 450.0, 160, 1.1, (Intern) petya, "Написать микросервис");
        List<Employee> teamList = new ArrayList<>();
        teamList.add(petya);
        teamList.add(vasya);
        Employee ivan = new TeamLeader("Иван", 600, 200, teamList, "ABC");

        //a)
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(petya);
        employeeSet.add(vasya);
        employeeSet.add(ivan);
        //b)
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(petya);
        employeeList.add(vasya);
        employeeList.add(ivan);

        for (Employee employee : employeeList)
            System.out.println(employee.getClass().getSimpleName() + " " +
                    employee.getName() + ". Зарплата: " + employee.calcSalary());

    }
}
