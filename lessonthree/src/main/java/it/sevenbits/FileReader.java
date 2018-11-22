package it.sevenbits;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * FileReader does file work. It reads lines and checks if there's more lines available
 */
public class FileReader {
    private String path;
    private BufferedReader bw;
    private int count;

    /**
     * The constructor
     * @param path is a path name
     */
    public FileReader(final String path) {
        this.path = path;
        count = 0;
        try {
            bw = new BufferedReader(new InputStreamReader(new FileInputStream(path), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method reads and returns a single line
     * @return line that's read
     * @throws FileReaderException if something goes wrong
     */
    public String readLine() throws FileReaderException {
        count++;
        try {
            if (hasMoreLines()) {
                return new StringBuilder(path).append(" ").append(count).append(" ").append(bw.readLine()).toString();
            }
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
        return null;
    }

    /**
     * Method checks is there's more lines to be read
     * @return true if it is otherwise false
     * @throws FileReaderException if something goes wrong
     */
    public boolean hasMoreLines() throws FileReaderException {
        try {
            return bw.ready();
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }

    /**
     * Method closes the stream
     * @throws IOException
     */
    public void close() throws IOException {
        try {
            bw.close();
        } catch (IOException e) {
            throw new FileReaderException(e);
        }
    }
}
