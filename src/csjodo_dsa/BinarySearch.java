package csjodo_dsa;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] arr, int target){
        Arrays.sort(arr);
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while(leftPointer <= rightPointer){
            int centerIndex = (leftPointer + rightPointer) / 2;
            if(arr[centerIndex] == target){
                return centerIndex;
            }
            else if(arr[centerIndex] < target){
                leftPointer = centerIndex + 1;
            }
            else{
                rightPointer = centerIndex - 1;
            }
        }
        return -1;
    }
}
