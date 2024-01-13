package LeetCode75;

import java.util.Arrays;

public class FindPivotIndex {
    public static int pivotIndex(int[] nums) { // works based on the hints/instructions but less efficient
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        sumLeft[0] = nums[0];
        sumRight[nums.length-1] = nums[nums.length-1];
        for(int i = 1; i < nums.length; i++){
            sumLeft[i] = sumLeft[i - 1] + nums[i];
            sumRight[sumRight.length - i - 1] = sumRight[sumRight.length - i] + nums[sumRight.length - i - 1];
        }
        System.out.println(Arrays.toString(sumLeft));
        System.out.println(Arrays.toString(sumRight));
        for(int j = 0; j < nums.length; j++){
            if(sumLeft[j] == sumRight[j]){
                return j;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) { // works more efficiently but not exactly based on the instructions/hints
        int totalSum = 0;
        int leftSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        System.out.println(totalSum);
        for(int i = 0; i < nums.length; i++){
            if(totalSum - nums[i] == leftSum * 2){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void testPivotIndex(){
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(pivotIndex2(nums));

        int [] nums1 = new int[]{-1,-1,-1,-1,-1,0};
        System.out.println(pivotIndex2(nums1));
    }
}
