package it.sevenbits;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileReaderTest {
    File file1;
    File file2;

    @Before
    public void initialize() throws IOException {
        file1 = new File("test.txt");
        file1.createNewFile();
        file2 = new File("MyHomework.txt");
        file2.createNewFile();
    }
    @Test
    public void readLine() throws FileReaderException {
        FileReader fileReader = new FileReader(file1.getPath());

        assertEquals(fileReader.readLine(), "test.txt 1 Lesson three");
        assertEquals(fileReader.readLine(), "test.txt 2 Leaves are falling");
        assertEquals(fileReader.readLine(), "test.txt 3 Keep calm and love autumn");
        assertEquals(fileReader.readLine(), "test.txt 4 The quick brown fox jumps over the lazy dog");
        assertEquals(fileReader.readLine(), "test.txt 5 Now go back to work");

        FileReader fileReader1 = new FileReader(file2.getPath());

        assertEquals(fileReader1.readLine(), "MyHomework.txt 1 А ларчик просто открывался");
        assertEquals(fileReader1.readLine(), "MyHomework.txt 2 Fokina");
        assertFalse(fileReader1.hasMoreLines());
    }
}