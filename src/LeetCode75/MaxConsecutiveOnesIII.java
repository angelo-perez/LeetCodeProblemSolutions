package LeetCode75;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroesCount = 0; // counts the number of zeroes in a sub-array
        while(right < nums.length){
            if(nums[right] == 0){
                zeroesCount++;
            }
            right++; //always move the right pointer
            if(zeroesCount > k){ // check if the number of zeroes are greater than k
                if(nums[left] == 0){ // if left pointer's value is 0, reduce the zeroes count
                    zeroesCount--;
                }
                left++; // move the left pointer as long as the zeroes count is greater than k
            }
        }
        return right - left; // return the difference of right and left pointer to get the longestOnes
    }

    public static void testLongestOnes(){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0}; // 6
        int k = 2;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; // 10
        k = 3;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{0,0,0,1}; // 4
        k = 4;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{1,1,1,0,0,0,1,1,1,1}; // 4
        k = 0;
        System.out.println(longestOnes(nums, k));
    }
}
