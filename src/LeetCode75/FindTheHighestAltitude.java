package LeetCode75;

import java.util.Arrays;

public class FindTheHighestAltitude {
    public static int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        altitudes[0] = 0;
        int highestAlt = altitudes[0];
        for(int i = 1; i < altitudes.length; i++){
            altitudes[i] = altitudes[i-1] + gain[i-1];
            highestAlt = Math.max(highestAlt, altitudes[i]);
        }
        System.out.println(Arrays.toString(altitudes));
        return highestAlt;
    }

    public static void testLargestAltitude(){
        int[] gain = new int[]{-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
}
