package com.company;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AveragerTest {

    private Averager avgrSimple;
    private Averager avgrComplex;

    @Before
    public void setUp() {
        avgrSimple = new Averager("a quick brown fox, a dog", ".!?,;", 2);
        avgrComplex = new Averager("The enormous, pungent, and extremely well " +
                "marketed Maine Lobster Festival is held every late July in the " +
                "state’s midcoast region, meaning the western side of Penobscot " +
                "Bay, the nerve stem of Maine’s lobster industry. What’s called the " +
                "midcoast runs from Owl’s Head and Thomaston in the south to" +
                " Belfast in the north. (Actually, it might extend all the way " +
                "up to Bucksport, but we were never able to get farther north " +
                "than Belfast on Route 1, whose summer traffic is, as you can " +
                "imagine, unimaginable.) The region’s two main communities are " +
                "Camden, with its very old money and yachty harbor and five-star " +
                "restaurants and phenomenal B&Bs, and Rockland, a serious old " +
                "fishing town that hosts the Festival every summer in historic " +
                "Harbor Park, right along the water.",
                ".", 1);
    }

    @After
    public void tearDown() {
        avgrSimple = null;
        avgrComplex = null;
    }

    @Test
    public void testGetAverageSentenceLength1() throws Exception {
        int avgLength = avgrSimple.getAverageSentenceLength();
        assertEquals(2, avgLength);
    }

    @Test
    public void testGetAverageSentenceLength2() throws Exception {
        int avgLength = avgrComplex.getAverageSentenceLength();
        assertEquals(31, avgLength);
    }

}