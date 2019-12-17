package stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class DoubleListStatisticsTest {

    List<Double> values;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        values = Arrays.asList(4.8, 7.0, 9.1, 10.9, 13.0, 15.0, 17.0, 19.2);
    }

    @Test
    public void avgIterative() {
        Double sum = 0d;
        for (Double vals : values) {
            sum += vals;
        }
        Double avg = sum / values.size();

        assertEquals(12, avg, DELTA);
    }

    @Test
    public void avgWithLambdas() {
        OptionalDouble avg1 = values.stream().mapToDouble(d -> d).average();
        assertEquals(12, avg1.getAsDouble(), DELTA);

        Double sum = values.stream().mapToDouble(x -> x).sum();
        assertEquals(96, sum, DELTA);
    }

    @Test
    public void avgWithReduce() {
        long valuesInList = values.stream().count();

        Double sum2 = values.stream().reduce(0.0, Double::sum);
        assertEquals(12, sum2 / valuesInList, DELTA);
    }

    @Test
    public void avgWithStatistics() {
        DoubleSummaryStatistics stats = values.stream()
                .collect(Collectors.summarizingDouble(Double::doubleValue));

        assertEquals(96, stats.getSum(), DELTA);
        assertEquals(12, stats.getAverage(), DELTA);
        assertEquals(4.8, stats.getMin(), DELTA);

    }

    @Test
    public void avgWithStatistics2() {
        DoubleSummaryStatistics stats = values.stream()
                .mapToDouble(Double::doubleValue).summaryStatistics();

        assertEquals(96, stats.getSum(), DELTA);
        assertEquals(12, stats.getAverage(), DELTA);
    }

}
