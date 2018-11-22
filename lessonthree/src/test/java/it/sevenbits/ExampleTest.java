package it.sevenbits;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;

public class ExampleTest {
    FileReader reader1;
    FileReader reader2;
    FileReader reader3;
    Example example;

    @Before
    public void initialize() throws FileReaderException {
        reader1 = Mockito.mock(FileReader.class);
        Mockito.when(reader1.readLine()).thenReturn("test.txt 1 Lesson three",
                "test.txt 2 Leaves are falling",
                "test.txt 3 Keep calm and love autumn",
                "test.txt 4 The quick brown fox jumps over the lazy dog", "Now go back to work");
        Mockito.when(reader1.hasMoreLines()).thenReturn(true, true, true, true, true, false);

        reader2 = Mockito.mock(FileReader.class);
        Mockito.when(reader2.readLine()).thenReturn("MyHomework.txt 1 А ларчик просто открывался", "MyHomework.txt 2 Fokina");
        Mockito.when(reader2.hasMoreLines()).thenReturn(true, true, false);
        reader3 = Mockito.mock(FileReader.class);
        Mockito.when(reader3.readLine()).thenReturn(null);
        Mockito.when(reader3.hasMoreLines()).thenReturn(false);
        example = new Example();
}

    @Test
    public void getLongestLineCharsCountTest() {
        try {
            assertEquals(example.getLongestLineCharsCount(reader2), 43);
            assertEquals(example.getLongestLineCharsCount(reader1), 54);
        } catch (FileReaderException e) {
            e.printStackTrace();
        }
    }
    @Test()
    public void getLongestLineCharsCountTestEmpty() throws FileReaderException {
        assertEquals(example.getLongestLineCharsCount(reader3), 0);
    }
}