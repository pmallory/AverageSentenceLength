package com.company;

import java.io.File;

/**
 * Created by Philip on 6/1/14.
 */
public class ArgParser {

    private String[] args;

    public ArgParser(String[] args) {
        if (args.length < 1 || args.length > 5) {
            throw new IllegalArgumentException();
        }
        this.args = args;
    }

    String getPathString() {
        String pathString = args[0];
        File f = new File(pathString);
        if (!f.exists()) {
            System.out.println("File: " + args[0] + " does not exist.");
            System.exit(1);
        }
        return pathString;
    }

    String getDelimiters() {
        String delimiters = getFlagValue("-d", this.args);

        if (delimiters != null)
            return delimiters;

        return ".!?,;"; // The default delimiters if none are specified
    }

    Integer getWordLength() {
        Integer wordLength;

        String flagValue = getFlagValue("-l", this.args);

        if (flagValue != null) {
            try {
                wordLength = Integer.parseInt(flagValue);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        } else {
            wordLength = 3;
        }

        return wordLength;
    }

    /**
     * Get the value of the command line argument specified by a flag
     *
     * Examples:
     * args = "input.txt -d "." -l 2"
     * flag = "-d"
     * returns "."
     *
     * args = "input.txt -d "." -l 2"
     * flag = "-x"
     * returns null
     *
     * @param flag eg "-d"
     * @param args the array of arguments passed to the program
     * @return the value associated with the flag, or null
     *
     */
    String getFlagValue(String flag, String[] args) {
        for (int i = 0; i<args.length; i++) {
            if (args[i].equals(flag)) {
                try {
                    return args[i+1];
                } catch(ArrayIndexOutOfBoundsException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        return null;
    }

}
