package optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import base.Employee;

public class OptionalNullubleDemo {

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        for (Employee employee : employees) {
            if (employee.getAge() == null)
                System.out.println(employee);
        }

        System.out.println("***All employees, which has age");
        for (Employee employee : employees) {
            Optional<Integer> optionalAge = Optional
                    .ofNullable(employee.getAge()); // of() - NullPointerException
            // Optional<Integer> optionalAge = Optional.of(employee.getAge()); // of() -
            // NullPointerException
            if (optionalAge.isPresent()) { // tarkastaa, onko arvo saatavilla
                System.out.println(employee);
            }
        }

        System.out.println("***All employees, which has NULL age");
        for (Employee employee : employees) {
            Optional<Integer> optionalAge = Optional
                    .ofNullable(employee.getAge());
            if (!optionalAge.isPresent()) {
                System.out.println(employee);
            }
        }
    }

    public static List<Employee> createEmployees() {
        Employee e1 = new Employee(39, "F", "Trace Kingston");
        Employee e2 = new Employee(13, "F", "Martina Hengis");
        Employee e3 = new Employee(49, "M", "Ricky Martin");
        Employee e4 = new Employee(16, "M", "Harold Tash");
        Employee e5 = new Employee(59, "F", "Nanny Boatwright");
        Employee e6 = new Employee(15, "F", "Emmet Derby");
        Employee e7 = new Employee(19, "M", "Martie Mathews");
        Employee e8 = new Employee(47, "M", "Dean Ellison");
        Employee e9 = new Employee(56, null, null);
        Employee e10 = new Employee(null, "F", "Annie Frankie");
        Employee e11 = new Employee(null, null, null);

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5,
                e6, e7, e8, e9, e10, e11 }));

        return employees;
    }

}
