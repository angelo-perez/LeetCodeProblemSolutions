package LeetCode75;

public class MaximumAverageSubarrayI { // Sliding Windows Algorithm
    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }
        int maxSum = sum;
        for(int j = 1; j < nums.length - k + 1; j++){
            sum = sum - nums[j-1] + nums[j + k - 1];
            maxSum = Math.max(maxSum, sum); // get the highest sub-array sum and compute for average later on
                                            // an efficient way to avoid repetitive average computation and comparison
        }
        return (double) maxSum / k; // compute average using the max sum and k
//        double factor = 1e5; // (1 * 10^5) for formatting to 5 decimal places
//        return Math.round(((double) maxSum / k)*factor) / factor; // to be able to format in 5 decimal places
    }

    public static void testFindMaxAverage(){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums,k));
    }
}
