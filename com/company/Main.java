package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        String textFilePath = null;
        String delimiters = null;
        Integer minimumWordLength = null;

        ArgParser ap = new ArgParser(args);
        try {
             textFilePath = ap.getPathString();
             delimiters = ap.getDelimiters();
             minimumWordLength = ap.getWordLength();
        } catch (IllegalArgumentException e) {
            System.out.println("Bad arguments\n" +
                    "Example of correct usage:\n" +
                    "AverageSentenceLength file.txt [-d \".?!\"] -l 2");
            System.exit(1);
        }

        String text = readFile(textFilePath);

        Averager averager = new Averager(text, delimiters, minimumWordLength);
        System.out.println("Average words per sentence: " + averager.getAverageSentenceLength());
    }

    static String readFile(String path) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            return new String(bytes);
        } catch (IOException e) {
            System.out.println("Error reading file: " + path);
            System.exit(1);
        }
        return null;
    }
}
