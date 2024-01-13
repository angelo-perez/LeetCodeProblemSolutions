package LeetcodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class TwoSum {
    public static int[] twoSumNested(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return nums;
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(numbers.containsKey(nums[i])){
                return new int[]{numbers.get(nums[i]), i};
            }
            int diff = target - nums[i];
            numbers.put(diff, i);
        }
        System.out.println("HashMap: " + numbers);
        return nums;
    }


    public static void testTwoSum(){ // 3,0 4,1
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSumNested(nums, target)));
        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
    }
}
