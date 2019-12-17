
package files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadDir {

    public static List<Path> lsDir(String dir) {
        List<Path> files = new ArrayList<>();

        try (DirectoryStream<Path> dirStream = Files
                .newDirectoryStream(Paths.get(dir))) {
            for (Path path : dirStream) {
                files.add(path);
            }
        } catch (IOException ex) {
        }
        return files;
    }

    public static void main(String[] args) throws IOException {
        List<Path> dirList = lsDir(".");

        dirList.stream().forEach(f -> System.out.println(
                    f.toString() + ", " + f.toFile().length() + " bytes"));
    }
}
