package lesson5_Рекурсия;

import java.io.File;

public class ShowFiles {
    public static void main(String[] args) {
        File file = new File("D:\\gb_Algorithms");
        viewFiles(file);
    }

// вывод файлом с префиксом
    private static void viewFiles(File file, int level) {

        String prefix = "\t".repeat(level);
        if (file.isFile()) {
            System.out.println(prefix + "File: " + file.getName());
        } else {
            System.out.println(prefix + "Directory: " + file.getName());
            level++;

            for (File listFile : file.listFiles()) {
                viewFiles(listFile, level);
            }
        }
    }

    private static void viewFiles(File file) {
        viewFiles(file, 0);
    }
}
