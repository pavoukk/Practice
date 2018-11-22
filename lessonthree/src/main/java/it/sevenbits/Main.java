package it.sevenbits;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * main class
 */
public final class Main {
    private Main(){}
    /**
     * main method
     * @param args args
     */
    public static void main(final String[] args) {
        FileWorks fw = new FileWorks();
        File file = new File("Homework3.txt");
        if (file.exists()) {
            File file1 = fw.makeFile("MyHomework.txt");
            System.out.println(file1.exists());
            fw.writeToOtherFile(file, file1);
            try (ByteArrayInputStream bais = new ByteArrayInputStream("Fokina".getBytes());
                 FileOutputStream fos = new FileOutputStream(file1, true)) {
                byte[] arr = new byte[bais.available()];
                bais.read(arr);
                fos.write(arr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
