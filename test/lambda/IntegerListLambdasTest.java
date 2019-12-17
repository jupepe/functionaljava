package lambda;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class IntegerListLambdasTest {
    List<Integer> values;

    @Before
    public void setUp() {
        values = Arrays.asList(5, 10, 15, 20, 25);
    }

    @Test
    public void countTraditionally() {

        List<Integer> result = new ArrayList<>(values.size());
        for (int i : values) {
            result.add(i * i);
        }

        System.out.println(result);
        assertEquals((Integer)100, result.get(1));
        assertEquals((Integer)225, result.get(2));
        assertEquals(5, result.size());
    }

    @Test
    public void countUsingLambdas() {

        List<Integer> result = values.stream().map(i -> i * i)
                .collect(Collectors.toList());

        System.out.println(result);
        assertEquals((Integer)100, result.get(1));
        assertEquals((Integer)225, result.get(2));
        assertEquals(5, result.size());
    }

}