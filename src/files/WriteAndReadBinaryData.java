package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteAndReadBinaryData {

    final static String input_img = "newlogo.jpg";
    final static String output_img = "copyoflogo.jpg";

    public static void main(String... args) throws IOException {
        byte[] bytes = readBinaryFile(input_img);
        System.out.println("Size of file:" + bytes.length);
        writeBinaryFile(bytes, output_img);
    }

    public static byte[] readBinaryFile(String fileName)
            throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllBytes(path);
    }

    public static void writeBinaryFile(byte[] bytes, String fileName)
            throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, bytes);
    }
}
