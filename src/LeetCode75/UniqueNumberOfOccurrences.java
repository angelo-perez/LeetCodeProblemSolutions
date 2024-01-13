package LeetCode75;

import java.util.*;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numCountCollection = new HashMap<>();
        for(int num : arr){
            if(!numCountCollection.containsKey(num)){
                numCountCollection.put(num, 1);
            }
            else {
                numCountCollection.put(num, numCountCollection.get(num) + 1);
            }
        }
        System.out.println(numCountCollection);
        int[] modeArr = new int[numCountCollection.size()];
        int count = 0;
        for(int mode : numCountCollection.values()){
            modeArr[count] = mode;
            count++;
        }
        Arrays.sort(modeArr);
        for(int i = 0; i < modeArr.length - 1; i++){
            if(modeArr[i] == modeArr[i+1]){
                return false;
            }
        }
        return true;
//        Object[] modeArr = numCountCollection.values().toArray();
//        for(int i = 0; i < modeArr.length; i++){
//            for(int j = i + 1; j < modeArr.length; j++){
//                if(modeArr[i] == modeArr[j]) return false;
//            }
//        }
//        return true;

//        HashSet<Integer> modes = new HashSet<>(numCountCollection.values());
//        int sumModes = 0;
//        for(int val : modes){
//            sumModes += val;
//        }
//        return sumModes == arr.length;
    }

    public static boolean uniqueOccurrencesWithoutHashMap(int[] arr){
        Arrays.sort(arr);
        ArrayList<Integer> modes = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                count++;
                if(modes.size() == 0){
                    modes.add(count);
                }
                else{
                    modes.set(modes.size() - 1, count);
                }
            }
            else{
                int last = 0;
                if (modes.size() > 0) {
                    last = modes.get(modes.size() - 1);
                    modes.remove(modes.size() - 1);
                }
                else{
                    modes.remove(0);
                }
                if(modes.contains(last)){
                    return false;
                }
                modes.add(last);
                count = 1;
                modes.add(count);
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(modes);
        return true;
    }

    public static void testUniqueOccurrences(){
        int[] arr = new int[]{1,2,2,1,1,3,2}; //1 1 1 2 2 3
//        System.out.println(uniqueOccurrences(arr));
        System.out.println(uniqueOccurrencesWithoutHashMap(arr));
    }
}
