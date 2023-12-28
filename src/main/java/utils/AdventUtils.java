package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AdventUtils {

    public static List<String> readLinesFromResourceFiles(String resourceFileName) throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(resourceFileName)) {
            if (inputStream == null) {
                String message = String.format("Could not get input stream for resource file: {}", resourceFileName);
                throw new IOException(message);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            return bufferedReader.lines().collect(Collectors.toList());
        }
    }
}
