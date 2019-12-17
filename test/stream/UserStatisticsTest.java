package stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;


public class UserStatisticsTest {

    class User {
        private String name;
        public int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    
    private List<User> users;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp() {
        // Voi sisältää null arvoja sekä myös name voi olla null
        users = Arrays.asList(new User("jack", 40), new User("john", 32),
                new User("jill", 47), new User("mike", 28),
                new User("bob", 51), new User(null, -1), null, null, null,
                null);
    }

    @Test
    public void traditionalJavaAvg() {
        Double sum = 0.0;
        for (User user : users) {
            if (user != null && user.getName() != null)
                sum += user.getAge();
        }
        // null tarkastus filter-metodissa
        // Double avg = sum / users.size();
        Double avg = sum / (users.size() - (users.stream()
                .filter(u -> u == null || u.getName() == null).count()));

        assertEquals(39.6, avg, DELTA);
    }

    @Test
    public void summaryStats() {
        IntSummaryStatistics stats = users.stream()
                .filter(u -> u != null && u.getName() != null)
                .mapToInt(User::getAge).summaryStatistics();

        assertEquals(39.6, stats.getAverage(), DELTA);
        assertEquals(5, stats.getCount());
        assertEquals(51, stats.getMax());
        assertEquals(28, stats.getMin());
        assertEquals(198, stats.getSum());
    }

    @Test
    public void summaryStatsReductionTarget() {
        IntSummaryStatistics stats = users.stream()
                .filter(u -> u != null && u.getName() != null)
                .collect(Collectors.summarizingInt(User::getAge));

        assertEquals(39.6, stats.getAverage(), DELTA);
        assertEquals(5, stats.getCount());
        assertEquals(51, stats.getMax());
        assertEquals(28, stats.getMin());
        assertEquals(198, stats.getSum());
    }

}