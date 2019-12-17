package stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import base.WorkerInfo;

public class AnonoymousClassSortingWorkersTest {

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
    public void sortWithAnonymousClass() {

        Collections.sort(disneyWorkers, new Comparator<WorkerInfo>() {
            @Override
            public int compare(WorkerInfo worker1, WorkerInfo worker2) {
                return worker1.getName().compareTo(worker2.getName());
            }
        });
        // koko Comparator-olio voidaan korvata lambda-lausekkeella yhdellä
        // rivillä!
        Collections.sort(disneyWorkers,
                (w1, w2) -> w1.getName().compareTo(w2.getName()));
        // tai comparing(metodiviittaus) - kaikki kolme antaa saman järjestyksen
        Collections.sort(disneyWorkers,
                Comparator.comparing(WorkerInfo::getName));
        // tai kääntäen nimien mukaan järjestyksen
        Collections.sort(disneyWorkers,
                Comparator.comparing(WorkerInfo::getName).reversed());
        // voi antaa useampia sorttausehtoja: ensin name ja sitten birthdate
        Collections.sort(disneyWorkers,
                Comparator.comparing(WorkerInfo::getName)
                        .thenComparing(WorkerInfo::getBirthdate));
        Collections.sort(disneyWorkers,
                Comparator.comparing(WorkerInfo::getName));
        assertEquals(new WorkerInfo("Beeva, Eega", "1947-05-01"),
                disneyWorkers.get(0));
        assertEquals(new WorkerInfo("Black, Pete", "1925-06-01"),
                disneyWorkers.get(1));
        assertEquals(new WorkerInfo("Duck, Louie", "1937-06-01"),
                disneyWorkers.get(8));
        assertEquals(new WorkerInfo("Gander, Gladstone", "1948-01-01"),
                disneyWorkers.get(9));
        assertEquals(new WorkerInfo("Mouse, Minnie", "1928-11-18"),
                disneyWorkers.get(disneyWorkers.size() - 3));
        assertEquals(new WorkerInfo("O'Hara, Chief", "1935-06-01"),
                disneyWorkers.get(disneyWorkers.size() - 2));
        assertEquals(new WorkerInfo("Pluto", "1930-06-01"),
                disneyWorkers.get(disneyWorkers.size() - 1));
    }

}
