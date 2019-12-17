package stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import base.Employee;

public class FilteringEmployees {

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        System.out.println("***All employees, who are male and over 18");
        System.out.println(filterEmployees(employees, isAdultMale()));

        System.out.println("***All employees, who are female and over 20");
        System.out.println(filterEmployees(employees, isAdultFemale()));

        System.out.println("***All employees, who are older than 40");
        System.out.println(filterEmployees(employees, isOlderThan(40)));

        System.out.println("***All employees, who are younger than 40");

        System.out.println(
                filterEmployees(employees, isOlderThan(40).negate()));
        System.out.println(filterEmployees(employees, isYoungerThan(40)));

        System.out.println(
                "***All employees, who's name is longer than 14 chars");
        System.out
                .println(filterEmployees(employees, isNameLongerThan(14)));

    }

    public static Predicate<Employee> isMale() {
        return p -> p.getGender() != null && p.getGender().equals("M");
    }

    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() != null && p.getGender() != null
                && p.getAge() >= 20 && p.getGender().equals("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() != null && p.getGender() != null
                && p.getAge() >= 18 && p.getGender().equals("F");
    }

    public static Predicate<Employee> isOlderThan(Integer age) {
        return p -> p.getAge() != null && p.getAge() >= age;
    }

    public static Predicate<Employee> isYoungerThan(Integer age) {
        return p -> p.getAge() != null && p.getAge() <= age;
    }

    public static Predicate<Employee> isNameLongerThan(Integer charCount) {
        return p -> p.getName() != null
                && p.getName().length() >= charCount;
    }

    public static List<Employee> filterEmployees(List<Employee> employees,
            Predicate<Employee> predicate) {
        return employees.stream().filter(predicate)
                .collect(Collectors.toList());
    }

    public static List<Employee> createEmployees() {
        Employee e1 = new Employee(39, "F", "Trace Kingston");
        Employee e2 = new Employee(13, "F", "Martina Hengis");
        Employee e3 = new Employee(49, "M", "Ricky Martin");
        Employee e4 = new Employee(16, "M", "Harold Tash	");
        Employee e5 = new Employee(59, "F", "Nanny Boatwright");
        Employee e6 = new Employee(15, "F", "Emmet Derby");
        Employee e7 = new Employee(19, "M", "Martie Mathews");
        Employee e8 = new Employee(47, "M", "Dean Ellison");
        Employee e9 = new Employee(null, "F", "Annie Frankie");

        return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9);
    }

}
