package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil {

    public static void writeToFile(String path, String content) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write(content);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
