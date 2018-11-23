package it.sevenbits;

import java.io.*;

public class FileWorks {
    public File getFileInformation(File directory){
        File file = new File("test.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            File[] files = directory.listFiles();
            for (File f:files) {
                bw.write(f.getName() + " ");
                if(f.isDirectory()){
                   bw.write("directory ");
                } else if(f.isFile()){
                    bw.write("file ");
                }
                bw.write("can write: " + f.canWrite() + " ");
                bw.write("can read: " + f.canRead() + " ");
                bw.write("can execute: " + f.canExecute() + " ");
                bw.write(f.getAbsolutePath());
                bw.newLine();
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
