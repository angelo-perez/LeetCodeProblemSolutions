package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> totalAsteroids = new ArrayList<>();
        for(int num : asteroids){
            totalAsteroids.add(num);
        }
        int left = 0;
        int right = 1;
        while(right < totalAsteroids.size()){
            if((totalAsteroids.get(left) > 0 && totalAsteroids.get(right) < 0)
            || (totalAsteroids.get(right) > 0 && totalAsteroids.get(left) < 0)){
                if(Math.abs(totalAsteroids.get(left)) > Math.abs(totalAsteroids.get(right))){
//                    totalAsteroids.remove(right);
                    totalAsteroids.set(right, 0);
                    right++;
                }
                else if(Math.abs(totalAsteroids.get(left)) == Math.abs(totalAsteroids.get(right))){
                    totalAsteroids.set(left, 0);
                    totalAsteroids.set(right, 0);
                    left++;
                    right++;
                }
                else{
//                    totalAsteroids.remove(left);
                    totalAsteroids.set(left, 0);
                    left++;
                }
            }
            else{
                left++;
                right++;
            }
        }
        totalAsteroids.removeAll(Collections.singleton(0));
        int[] ans = new int[totalAsteroids.size()];
        for(int i = 0; i < totalAsteroids.size(); i++){
            if(totalAsteroids.get(i) != 0){
                ans[i] = totalAsteroids.get(i);
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public static void testAsteroidCollision(){
        int[] asteroids = {5,10,-5, -7};
        System.out.println(asteroidCollision(asteroids));
    }
}
