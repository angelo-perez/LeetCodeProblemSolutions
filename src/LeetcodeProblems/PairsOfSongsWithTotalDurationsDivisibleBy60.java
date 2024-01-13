package LeetcodeProblems;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static int numPairsDivisibleBy60UsingArrayCounting(int[] time) { // slightly more efficient
        int[] remainders = new int[60];
        int count = 0;

        for (int t : time) {
            // Calculate the remainder when dividing the time by 60
            int remainder = t % 60;

            // Check the complement remainder needed for the current time to form a pair
            int complement = (60 - remainder) % 60;

            // Count pairs with the same complement remainder
            count += remainders[complement];

            // Update the remainders array
            remainders[remainder]++;
        }

        return count;
    }

    public static int numPairsDivisibleBy60UsingHashMap(int[] time) {
        HashMap<Integer, Integer> timeRemainderMap = new HashMap<>();
        int count = 0;

        for (int t : time) {
            // Calculate the remainder when dividing the time by 60
            int remainder = t % 60;

            // Check the complement remainder needed for the current time to form a pair
            int complement = (60 - remainder) % 60;

            // Check if the complement remainder exists in the map
            // If yes, add its frequency to the total count
            count += timeRemainderMap.getOrDefault(complement, 0);

            // Update the map with the current remainder
            timeRemainderMap.put(remainder, timeRemainderMap.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
