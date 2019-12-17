package basic.basic2functional;

import java.util.List;

import base.Person;
import base.Worker;

public class DerivedClassArrayFunctionalDemo {

    public static void main(String[] args) {
        Person bill = new Person("A321", "Bill");
        Worker steven = new Worker("B123", "Steven", 40, 25);
        Worker billInWork = new Worker(bill.getId(), bill.getName(), 19.95, 30);

        List<Person> persons = List.of(bill,billInWork,steven);
        
        System.out.println("Printing all persons from ArrayList:");
        
        persons.stream().forEach(System.out::println);
    }
}
