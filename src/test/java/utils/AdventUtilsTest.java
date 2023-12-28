package utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.io.IOException;
import java.util.List;

public class AdventUtilsTest {

    @Test
    public void testReadLinesFromResourceFiles() throws IOException {
        String fileName = "input.txt";
        List<String> lines = AdventUtils.readLinesFromResourceFiles(fileName);
        Assertions.assertNotNull(lines);
        Assertions.assertEquals(3, lines.size());
        Assertions.assertEquals("test1", lines.get(0));
        Assertions.assertEquals("test2", lines.get(1));
        Assertions.assertEquals("test3", lines.get(2));
    }
}