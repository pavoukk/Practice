package it.sevenbits;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import  java.io.FileOutputStream;

/**
 * File works
 */
public class FileWorks {
    /**
     *Method creates new file
     * @param string file name
     * @return created file
     */
    public File makeFile(final String string) {
        return new File(string);
    }

    /**
     *
     * @param from wherefrom data is taken
     * @param to where data to be written
     */
    public void writeToOtherFile(final File from, final File to) {
        try (InputStream is = new FileInputStream(from); OutputStream os = new FileOutputStream(to)) {
            byte[] byteArr = new byte[is.available()];
            is.read(byteArr);
            os.write(byteArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
