package it.sevenbits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Example is an example
 */
public class Example {
    /**
     *
     * @param reader is a file reader
     * @return the longest line's chars amount
     * @throws FileReaderException is something goes wrong
     */
    public int getLongestLineCharsCount(final FileReader reader) throws FileReaderException {
        List<String> list = new ArrayList<>();
        while (reader.hasMoreLines()) {
            list.add(reader.readLine());
        }
        if (list != null) {
            return list.stream().max(Comparator.comparingInt(String::length)).orElse("").length();
        }
        return 0;
    }
}
