package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxNumberOfKSumPairs {
    public static int maxOperationsUsingSortingAndTwoPointer(int[] nums, int k) {
        Arrays.sort(nums); // sort the array for easier and more precise navigation of the pointers
        int numOperations = 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == k){
                numOperations++;
                left++;
                right--;
            }
            else if(nums[left] + nums[right] > k){ // move right pointer to decrease the value of sum
                right--;
            }
            else{ // move left pointer to increase the value of sum
                left++;
            }
        }
        return numOperations;
    }

    public static int maxOperationsUsingHashMap(int[] nums, int k){ // still have some error
        HashMap<Integer, Integer> numbers = new HashMap<>();
        int numOperations = 0;
        for(int i = 0; i < nums.length; i++){
            if(numbers.containsKey(nums[i])){
                numOperations++;
                numbers.remove((Integer) nums[i]);
                continue;
            }
            int diff = k - nums[i];
            numbers.put(diff, i);
        }
        System.out.println("HashMap: " + numbers);
        return numOperations;
    }


    public static void testMaxOperation(){
        int[] nums = new int[]{1,2,3,4};
        int k = 5;
        System.out.println(maxOperationsUsingSortingAndTwoPointer(nums, k));
        System.out.println(maxOperationsUsingHashMap(nums, k));
    }
}
