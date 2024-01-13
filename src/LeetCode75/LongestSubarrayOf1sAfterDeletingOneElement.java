package LeetCode75;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zerosCount = 0; // counts the number of zeroes in a sub-array
        while(right < nums.length){
            if(nums[right] == 0){ // checks if the current value of the right pointer is 0 and count it
                zerosCount++; // increase the number of zeroes
            }
            right++; // always moves the right pointer
            if(zerosCount > 1){ // checks if the number of zeroes in sub-array is more than 1
                if(nums[left] == 0){ // then checks if the current value of the left pointer is 0
                    zerosCount--; // decrease the number of zeroes
                }
                left++; // moves the left pointer if the number of allowed zeroes has been reached
            }
        }
        return right - left - 1; // return the difference of the right and left pointer and subtracts one from one (to comply with the required deletion of a single digit)
    }

    public static void testLongestSubarray(){
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));

        nums = new int[]{0,0,0,0,0,0};
        System.out.println(longestSubarray(nums));

        nums = new int[]{1,1,1,1};
        System.out.println(longestSubarray(nums));
    }
}
