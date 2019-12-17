package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FilterLines {

    public static void main(String[] args) {

        Path path = Paths.get("koe.txt");

        AtomicInteger index = new AtomicInteger();

        try (Stream<String> lines = Files.lines(path)) {
            lines.map(s -> index.incrementAndGet() + ":" + s)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("Filtering word 'java'");

        try (Stream<String> lines = Files.lines(path)) {
            lines.filter(s -> s.toLowerCase().contains("java"))
                    .forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
