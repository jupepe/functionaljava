package files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueTextLines {

    public static void main(String[] args) throws Exception {

        Path path = Paths.get("koe.txt"); // from Java 7

        List<String> uWords = null;
        try (Stream<String> lines = Files.lines(path)) {
            uWords = lines
                    .flatMap(r -> Arrays.stream(r.toLowerCase().split(" ")))
                    .distinct().collect(Collectors.toList());
        }

        System.out.println("Total number of the words int the text file "
                + uWords.size() + ".");

        uWords.stream().map(s -> s.toLowerCase())
                .forEach(s -> System.out.print(s + ", "));
    }
}