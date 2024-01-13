package test;

import LeetcodeProblems.PairsOfSongsWithTotalDurationsDivisibleBy60;
import org.junit.jupiter.api.Test;

import static LeetcodeProblems.PairsOfSongsWithTotalDurationsDivisibleBy60.*;
import static org.junit.jupiter.api.Assertions.*;

class PairsOfSongsWithTotalDurationsDivisibleBy60Test {

    @Test
    void testNumPairsDivisibleBy60() {
        int[] time = new int[]{30,20,150,100,40};
        assertEquals(3, numPairsDivisibleBy60UsingArrayCounting(time));
        assertEquals(3, numPairsDivisibleBy60UsingHashMap(time));
    }
}