package LeetCode75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> candieBool = new ArrayList<>();
        int mostCandies = 0;
        for(int candyNum : candies){
            mostCandies = Math.max(mostCandies, candyNum);
        }
        for(int candyNum : candies){
            candieBool.add(candyNum + extraCandies >= mostCandies);
        }
        return candieBool;
    }

    public static void testKidsWithCandies(){
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies).toString());
    }
}
