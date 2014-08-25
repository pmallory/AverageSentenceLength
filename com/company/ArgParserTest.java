package com.company;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArgParserTest {

    private ArgParser goodap;
    private String[] goodArgs = {"input.txt", "-d",  "\".\"", "-l", "2"};

    private ArgParser defaultap;
    private String[] defaultArgs = {"input.txt"};

    private ArgParser badap;
    private String[] badArgs = {"input.txt", "-d", "bad", "-l"};

    private ArgParser emptyap;
    private String[] emptyArgs = {};

    @Before
    public void setUp() {
        goodap = new ArgParser(goodArgs);
        defaultap = new ArgParser(defaultArgs);
        badap = new ArgParser(badArgs);
    }

    @After
    public void tearDown() {
        goodap = null;
        defaultap = null;
        badap = null;
        emptyap = null;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArgParser() {
        emptyap = new ArgParser(emptyArgs);
    }

    @Test
    public void testGetDelimiters1() {
        String delimiters = goodap.getDelimiters();
        assertEquals("\".\"", delimiters);
    }

    @Test
    public void testGetDelimiters2() {
        String delimiters = defaultap.getDelimiters();
        assertEquals(".!?,;", delimiters);
    }

    @Test
    public void testGetWordLength1() {
        int flag = goodap.getWordLength();
        assertEquals(flag, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWordLength2() {
        int flag = badap.getWordLength();
    }

    @Test
    public void testGetWordLength3() {
        int flag = defaultap.getWordLength();
        assertEquals(flag, 3);
    }

    @Test
    public void testGetFlagValue1() {
        String flag = goodap.getFlagValue("-d", goodArgs);
        assertEquals(flag, "\".\"");
    }

    @Test
    public void testGetFlagValue2() {
        String flag = goodap.getFlagValue("-l", goodArgs);
        assertEquals(flag, "2");
    }

    @Test
    public void testGetFlagValue3() {
        String flag = goodap.getFlagValue("-x", goodArgs);
        assertEquals(flag, null);
    }

}