package LeetCode75;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxWaterArea = 0;
        while(left < right){
            int wH = Math.min(height[left], height[right]); // water height
            int wD = right - left; // distance between left and right pointer
            int wA = wH*wD; // current calculated water area
            maxWaterArea = Math.max(wA, maxWaterArea); // store the highest water area
            if(height[left] < height[right]){
                left++;
            }
            else if (height[left] > height[right]) {
                right--;
            }
            else {
                if(height[left + 1] > height[right - 1]){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return maxWaterArea;
    }

    public static void testMaxArea(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        height = new int[]{1,1};
        System.out.println(maxArea(height));
    }
}
