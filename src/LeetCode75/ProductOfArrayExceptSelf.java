package LeetCode75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] productArr = new int[n];
        int[] leftPrefixProd = new int[n]; // '|\|\|\' pattern (left to right from bottom to top)
        int[] rightPrefixProd = new int[n]; // '/|/|/|' pattern (right ro left from bottom to top)

        leftPrefixProd[0] = 1; // setting the initial value of pattern to 1
        for(int i = 1; i < n; i++){ // Solving leftPrefixProd
            leftPrefixProd[i] = leftPrefixProd[i-1] * nums[i-1];
        }

        rightPrefixProd[n-1] = 1; // setting the initial value of pattern to 1
        for(int j = n - 2; j >=0; j--){ // Solving rightPrefixProd
            rightPrefixProd[j] = rightPrefixProd[j+1] * nums[j+1];
        }

        for(int k = 0; k < n; k++){ // multiplying each values of leftPrefixProd and rightPrefixProd
            productArr[k] = leftPrefixProd[k] * rightPrefixProd[k];
        }

        return productArr;
    }

    public static void testProductExceptSelf(){
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}
