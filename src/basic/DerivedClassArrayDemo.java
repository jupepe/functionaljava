package basic;

import base.Person;
import base.Worker;

public class DerivedClassArrayDemo {

    public static void main(String[] args) {
        Person bill = new Person("A321", "Bill");
        Worker steven = new Worker("B123", "Steven", 40, 25);

        Worker billInWork = new Worker();
        billInWork.setId(bill.getId());
        billInWork.setName(bill.getName());
        billInWork.setHourSalary(19.95);
        billInWork.setWorkingHours(30);

        java.util.ArrayList<Person> persons = new java.util.ArrayList<>();
        persons.add(bill);
        persons.add(billInWork);
        persons.add(steven);
        System.out.println("Printing all persons from ArrayList:");
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
