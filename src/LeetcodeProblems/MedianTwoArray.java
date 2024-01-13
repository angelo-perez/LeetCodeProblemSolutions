package LeetcodeProblems;

import java.util.Arrays;


public class MedianTwoArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        double median = 0.0;
        int[] combinedArr = new int[m + n];

        System.arraycopy(nums1, 0, combinedArr, 0, m);
        System.arraycopy(nums2, 0, combinedArr, m, n);

//
//        for (int i = 0; i < nums2.length; i++) {
//            combinedArr[i] = nums2[i];
//        }
//        for (int i = 0; i < nums1.length; i++) {
//            combinedArr[i + n] = nums1[i];
//        }

        int[] sortedArr = Arrays.stream(combinedArr).sorted().toArray();

        if(sortedArr.length%2 == 0){
            int index1 = sortedArr.length/2;
            int index2 = index1 - 1;
            median = (sortedArr[index1] + sortedArr[index2]) / 2.0;
        }
        else{
            int index = sortedArr.length/2;
            median = sortedArr[index] / 1.0;
        }

        System.out.println(Arrays.toString(sortedArr));

        return median;
    }
}
