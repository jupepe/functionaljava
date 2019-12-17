package stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ReduceCountingTest {

    final static List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 11,
            16, 21, 26, 25, 3);

    @Test
    public void collectEvenNumbers() {
        // filtteröi parilliset luvut
        // stream() - tekee streamin
        // filter(predicate) - suodattaa ne alkiot, joissa predikaatin arvo on true
        // collect(Collector) - päättää streamin ja prosessoi tulokset
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(4, evenNumbers.size());

        List<Integer> evenNumbersGreaterThan20 = evenNumbers.stream()
                .filter(n -> n % 2 == 0).filter(n -> n > 20)
                .collect(Collectors.toList());
        assertEquals(1, evenNumbersGreaterThan20.size());

    }

    @Test
    public void countSum2() {
        Integer sum = numbers.stream().filter(n -> n % 2 == 0)
                .reduce((a, b) -> a + b).get();
        assertEquals((Integer) 72, sum);

        Integer sum2 = numbers.stream().filter(n -> n % 2 == 1)
                .mapToInt(x -> x).sum();
        assertEquals((Integer) 80, sum2);
    }

    @Test
    public void collectOddNumbers() {
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 1)
                .collect(Collectors.toList());
        assertEquals(6, evenNumbers.size());
    }

    @Test
    public void sortNumbers() {
        List<Integer> res = numbers.stream().sorted(
                Comparator.comparingInt((Integer i) -> i).reversed())
                .collect(Collectors.toList());
        res.stream().forEach((item) -> System.out.println(item + ","));

        assertEquals((Integer) 26, res.get(0));
        assertEquals((Integer) 3, res.get(res.size() - 1));

    }

    @Test
    public void doubleNumbers() {
        List<Integer> numbers2 = numbers.stream().map(n -> n * n)
                .collect(Collectors.toList());
        assertEquals((Integer) 25, numbers2.get(0));
        assertEquals((Integer) 100, numbers2.get(1));

    }

    @Test
    public void countSum() {
        Integer result = numbers.stream().reduce((a, b) -> a + b).get();
        assertEquals((Integer) 152, result);
    }

    @Test
    public void createStringOfNumbers() {

        String result = numbers.stream().map(x -> x.toString())
                .reduce("Luvut:", (res, i) -> res + "," + i);
        assertEquals((Integer) result.length(), (Integer) 34);
    }

    // extra, keskiarvo valmiilla Collectors-metodilla
    @Test
    public void countAverage() {
        Double averageAge = numbers.stream()
                .collect(Collectors.averagingInt(n -> n));
        assertEquals((Double) averageAge, (Double) 15.2);
    }

}
