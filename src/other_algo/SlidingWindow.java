package other_algo;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindow {
    public static int[] findSumAllSubarraysFixedSized(int[] arr, int k){
        int numSubarrays = arr.length - k + 1;
        int[] sums = new int[numSubarrays];
        sums[0] = 0;
        for(int i = 0; i < k; i++){
            sums[0] += arr[i];
        }
        for(int j = 1; j < numSubarrays; j++){
            sums[j] = sums[j-1] - arr[j-1] + arr[j+k-1];
        }
        return sums;
    }

    public static int findLeastAddendsDynamicallySized(int[] arr, int x){
        int minLength = (int) Double.POSITIVE_INFINITY;
        int sum = 0;
        int right = 0;
        int left = 0;
        while(right < arr.length){
            // expanding end pointer
            sum += arr[right];
            right++;
            // limiting through start pointer
            while(left < right && sum >= x){
                sum -= arr[left];
                left++;
                minLength = Math.min(minLength, right - left + 1);
            }
        }
        System.out.println(minLength);

        return minLength;

    }

    public static void testFindSumAllSubarrays(){
        int[] nums = {1, 2, 4, 1, 3, 4, 1, 1};
        int k = 3;
        //System.out.println(Arrays.toString(findSumAllSubarraysFixedSized(nums, k)));

        int x = 8;
        System.out.println(findLeastAddendsDynamicallySized(nums, x));
    }
}
