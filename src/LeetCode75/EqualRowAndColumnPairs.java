package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class EqualRowAndColumnPairs {
    public static int equalPairs(int[][] grid) {
        HashMap<String,Integer> map = new HashMap<>(); // create a map for row values
        int n = grid.length;
        for(int i = 0; i < n; i++){
            StringBuilder rowStr = new StringBuilder();
            for(int j = 0; j < n; j++){
                rowStr.append(grid[i][j]).append(","); // convert row array to string with a separator ","
            }
            // add the rowStr to the map
            // default to 0 or get the value when it already exists then adds  1 (stores the frequency of each array in the row arrays as its value)
            map.put(rowStr.toString(), map.getOrDefault(rowStr.toString(), 0) + 1);
        }

        System.out.println(map);

        int equalPairs = 0; // counts the equal row and col strings(arrays)
        for(int i = 0; i < n; i++){
            StringBuilder colStr = new StringBuilder();
            for(int j = 0; j < n; j++){
                colStr.append(grid[j][i]).append(","); // convert col array to string with a separator ","
            }
            if(map.containsKey(colStr.toString())){ // check if map contains colStr
                equalPairs += map.get(colStr.toString()); // get the value then add it to the value of equalPairs
            }
        }
        return equalPairs;
    }

    public static void testEqualPairs(){
        int[][] grid = {{3,1,2,2},
                        {1,4,4,5},
                        {2,4,2,2},
                        {2,4,2,2}};

        System.out.println(equalPairs(grid));
    }
}
