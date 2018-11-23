package it.sevenbits;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/main/java/files");
        FileWorks fw = new FileWorks();
        File file = fw.getFileInformation(directory);
    }
}
