package stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import base.WorkerInfo;

public class LambdaSortingWorkersTest {

    final static List<WorkerInfo> disneyWorkers = Arrays.asList(
            new WorkerInfo("Duck, Donald", "1934-05-21"),
            new WorkerInfo("Mouse, Mickey", "1928-11-18"),
            new WorkerInfo("Goofy", "1932-06-01"),
            new WorkerInfo("Black, Pete", "1925-06-01"),
            new WorkerInfo("McDuck, Scrooge", "1947-12-01"),
            new WorkerInfo("Duck, Louie", "1937-06-01"),
            new WorkerInfo("Duck, Huey", "1937-06-01"),
            new WorkerInfo("Duck, Dewey", "1937-06-01"),
            new WorkerInfo("Duck, Daisy", "1940-06-01"),
            new WorkerInfo("Duck, Grandma", "1943-06-01"),
            new WorkerInfo("Gander, Gladstone", "1948-01-01"),
            new WorkerInfo("Goose, Gus", "1939-05-03"),
            new WorkerInfo("Pluto", "1930-06-01"),
            new WorkerInfo("Mouse, Minnie", "1928-11-18"),
            new WorkerInfo("Horsecollar, Horace", "1929-06-01"),
            new WorkerInfo("Gearloose, Gyro", "1952-05-01"),
            new WorkerInfo("Helper, Little", "1956-06-01"),
            new WorkerInfo("Beeva, Eega", "1947-05-01"),
            new WorkerInfo("O'Hara, Chief", "1935-06-01"),
            new WorkerInfo("Blot, Phantom", "1939-05-20"));

    @Test
    public void sortWithLambdasByName() {

        // compareTo() String -luokasta toteutus - käytetään sitä vertailussa

        List<WorkerInfo> resWorkers = disneyWorkers.stream()
                .sorted((w1, w2) -> w1.getName().compareTo(w2.getName()))
                .collect(Collectors.toList());
        System.out.println("Sort By name");
        disneyWorkers.stream().forEach(s -> System.out.print(s + ",\n"));
        System.out.println();

        assertEquals(new WorkerInfo("Beeva, Eega", "1947-05-01"),
                resWorkers.get(0));
        assertEquals(new WorkerInfo("Black, Pete", "1925-06-01"),
                resWorkers.get(1));
        assertEquals(new WorkerInfo("Pluto", "1930-06-01"),
                resWorkers.get(resWorkers.size() - 1));

    }

    @Test
    public void sortWithLambdasByBirthDay() {

        disneyWorkers.sort(
                (w1, w2) -> w1.getBirthdate().compareTo(w2.getBirthdate()));
        System.out.println("Sort By Birth date");
        disneyWorkers.stream().forEach(s -> System.out.print(s + ",\n"));
        System.out.println();

        assertEquals(disneyWorkers.get(0),
                new WorkerInfo("Black, Pete", "1925-06-01"));
        assertEquals(disneyWorkers.get(1),
                new WorkerInfo("Mouse, Mickey", "1928-11-18"));
        assertEquals(disneyWorkers.get(disneyWorkers.size() - 1),
                new WorkerInfo("Helper, Little", "1956-06-01"));
    }

    @Test
    public void sortWithLambdasByBirthDayReversed() {
        Comparator<WorkerInfo> comparator = (w1, w2) -> w1.getBirthdate()
                .compareTo(w2.getBirthdate());

        disneyWorkers.sort(((Comparator<WorkerInfo>) (w1, w2) -> w1
                .getBirthdate().compareTo(w2.getBirthdate())).reversed());

        disneyWorkers.sort(comparator.reversed()); // thenComparing, voi lisätä uusia järjestelylausekkeita

        assertEquals(disneyWorkers.get(disneyWorkers.size() - 1),
                new WorkerInfo("Black, Pete", "1925-06-01"));
        assertEquals(disneyWorkers.get(disneyWorkers.size() - 2),
                new WorkerInfo("Mouse, Minnie", "1928-11-18"));
        assertEquals(disneyWorkers.get(0),
                new WorkerInfo("Helper, Little", "1956-06-01"));
    }

    @Test
    public void sortWithLambdasByNameReference() {
        Collections.sort(disneyWorkers,
                Comparator.comparing(WorkerInfo::getName));

        assertEquals(disneyWorkers.get(0),
                new WorkerInfo("Beeva, Eega", "1947-05-01"));
        assertEquals(disneyWorkers.get(8),
                new WorkerInfo("Duck, Louie", "1937-06-01"));
        assertEquals(disneyWorkers.get(disneyWorkers.size() - 1),
                new WorkerInfo("Pluto", "1930-06-01"));
    }

    @Test
    public void sortWithLambdasByBirthDayAndName() {
        disneyWorkers.sort((w1, w2) -> {
            if (w1.getBirthdate().equals(w2.getBirthdate())) {
                return w1.getName().compareTo(w2.getName());
            }
            return w1.getBirthdate().compareTo(w2.getBirthdate());
        });

        assertEquals(disneyWorkers.get(0),
                new WorkerInfo("Black, Pete", "1925-06-01"));
        assertEquals(disneyWorkers.get(10),
                new WorkerInfo("Duck, Louie", "1937-06-01"));
        assertEquals(disneyWorkers.get(disneyWorkers.size() - 1),
                new WorkerInfo("Helper, Little", "1956-06-01"));
    }

    @Test
    public void sortWithLambdasByBirthDayAndNameComposition() {

        disneyWorkers.sort(Comparator.comparing(WorkerInfo::getBirthdate)
                .thenComparing(WorkerInfo::getName));

        assertEquals(disneyWorkers.get(0),
                new WorkerInfo("Black, Pete", "1925-06-01"));
        assertEquals(disneyWorkers.get(9),
                new WorkerInfo("Duck, Huey", "1937-06-01"));
        assertEquals(disneyWorkers.get(disneyWorkers.size() - 1),
                new WorkerInfo("Helper, Little", "1956-06-01"));
    }

}
