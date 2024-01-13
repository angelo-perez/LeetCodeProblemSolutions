package LeetCode75;

import java.util.Arrays;

public class MoveZeroes {
    public static int[] moveZeroesTwoPointerWithoutNestedLoop(int[] nums) { // SAME ALGORITHM BUT WITHOUT NESTED LOOP
        int left = 0;
        int right = 1;
        while(right < nums.length){
            if(nums[left] == 0 && nums[right] != 0){
                int tempNum = nums[left];
                nums[left] = nums[right];
                nums[right] = tempNum;
                left++;
                right++;
            }
            else if(nums[left] == 0 && nums[right] == 0){
                right++;
            }
            else{
                left++;
                right++;
            }
        }
        return nums;
    }
    public static int[] moveZeroesTwoPointerNestedLoop(int[] nums) { // SAME ALGORITHM BUT WITH NESTED LOOP
        int left = 0;
        int right = 1;
        while(right < nums.length){

            while(right < nums.length && ((nums[left] != 0 && nums[right] == 0) || (nums[left] != 0 && nums[right] != 0))){
                left++;
                right++;
            }

            if(right < nums.length){
                if(nums[left] == 0 && nums[right] != 0){
                    int tempNum = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tempNum;
                    left++;
                    right++;
                }
                else if(nums[left] == 0 && nums[right] == 0){
                    right++;
                }
            }
        }
        return nums;
    }
    public static void testMoveZeroes(){
        int[] nums = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(moveZeroesTwoPointerWithoutNestedLoop(nums)));
        System.out.println(Arrays.toString(moveZeroesTwoPointerNestedLoop(nums)));

        nums = new int[]{1,3,0,4,0};
        System.out.println(Arrays.toString(moveZeroesTwoPointerWithoutNestedLoop(nums)));
        System.out.println(Arrays.toString(moveZeroesTwoPointerNestedLoop(nums)));
    }
}
