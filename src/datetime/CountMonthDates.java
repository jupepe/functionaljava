package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class CountMonthDates {

    public static void main(String[] args) throws Exception {

        LocalDateTime endDate = LocalDateTime.of(LocalDate.of(2019, 10, 1),
                LocalTime.of(0, 0, 0));
        // Vähentää kuukautta yhdellä
        LocalDateTime timestamp = endDate.minus(Period.ofMonths(1));
        // period kaikkein geneerisin vaihtoehto, siinä toimivat metodit löytyy eri
        // arvojen käsittelyyn

        System.out.println(
                "Looping time from " + timestamp + " to " + endDate);
        do {
            // loop timestamp and add one day until endDate
            System.out.println(timestamp.toLocalDate() + " , weekday "
                    + timestamp.getDayOfWeek());
            timestamp = timestamp.plus(Period.ofDays(1));
        } while (timestamp.isBefore(endDate));

    }
}
