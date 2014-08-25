package com.company;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philip on 6/2/14.
 */
public class Averager {

    private String delimiters;
    private Integer minimumWordLength;
    private String text;

    public Averager(String text, String delimiters, Integer minimumWordLength) {
        this.delimiters = delimiters;
        this.minimumWordLength = minimumWordLength;
        this.text = text;
    }

    public Integer getAverageSentenceLength() {
        //A regex pattern that matches any of the delimiter characters
        String delimiterRegex = "["+this.delimiters+"]";

        String[] sentences = this.text.split(delimiterRegex);
        int sentenceCount = sentences.length;

        String[] words = this.text.split(" "); //All the words
        List<String> filteredWords = filter(words); //Words that are longer than the minumum

        int wordCount = filteredWords.size();

        return wordCount/sentenceCount;
    }

    private List<String> filter(String[] strings) {
        List<String> filteredList = new ArrayList<String>();

        for (String word:strings) {
            if (word.length() >= minimumWordLength)
                filteredList.add(word);
        }

        return filteredList;
    }
}
