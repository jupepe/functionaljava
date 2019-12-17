package datetime;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalTime;

/**
 * Example using java.time.LocalTime
 *
 */
public class LocalTimeDemo {

    public static void main(String[] args) throws Exception {
        LocalTime start = LocalTime.parse("15:30:30");
        LocalTime end = LocalTime.parse("16:12:43");
        
        System.out.println(start.until(end, MINUTES) + " minutes between "
                + start + " - " + end);
        System.out.println(MINUTES.between(start, end) + " minutes between "
                + start + " - " + end);
        LocalTime end2 = start.plusMinutes(65);
        System.out.println(MINUTES.between(start, end2) + " minutes between "
                + start + " - " + end2);
    }

}
