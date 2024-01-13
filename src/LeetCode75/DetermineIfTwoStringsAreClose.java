package LeetCode75;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
//    public static boolean closeStrings(String word1, String word2) {
//        if(word1.length() != word2.length()) return false;
//        HashMap<Character, Integer> word1Map = new HashMap<>();
//        HashMap<Character, Integer> word2Map = new HashMap<>();
//
//        for(int i = 0; i < word1.length(); i++){
//            Character currChar1 = word1.charAt(i);
//            if(!word1Map.containsKey(currChar1)){
//                word1Map.put(currChar1, 1);
//            }
//            else{
//                word1Map.put(currChar1, word1Map.get(currChar1) + 1);
//            }
//
//            Character currChar2 = word2.charAt(i);
//            if(!word2Map.containsKey(currChar2)){
//                word2Map.put(currChar2, 1);
//            }
//            else{
//                word2Map.put(currChar2, word2Map.get(currChar2) + 1);
//            }
//        }
//        System.out.println(word1Map);
//        System.out.println(word2Map);
//        char[] vals1 = new char[word1Map.size()];
//        char[] vals2 = new char[word2Map.size()];
//        int count = 0;
//        for(Integer key : word1Map.values()){
//            vals1[count] = Character.forDigit(key,word1Map.size() + 1);
//            count++;
//        }
//        count = 0;
//        for(Integer key : word2Map.values()){
//            vals2[count] = Character.forDigit(key,word2Map.size() + 1);
//            count++;
//        }
//        Arrays.sort(vals1);
//        Arrays.sort(vals2);
//
//        System.out.println(Arrays.toString(vals1));
//        System.out.println(Arrays.toString(vals2));
//
//        ArrayList<Character> charArrLst1 = new ArrayList<>(word1Map.keySet());
//        ArrayList<Character> charArrLst2 = new ArrayList<>(word2Map.keySet());
//        charArrLst1.removeAll(charArrLst2);
//
//        return Arrays.equals(vals1, vals2) && charArrLst1.isEmpty();
//    }

    public static boolean closeStrings(String word1, String word2){ // bad time complexity, good space complexity
        HashMap<Character, Integer> word1Map = new HashMap<>();
        HashMap<Character, Integer> word2Map = new HashMap<>();

        if(word1.length() != word2.length()) return false;
        for(int h = 0; h < word1.length(); h++){
            if(word1.indexOf(word2.charAt(h)) == -1) return false;
        }

        for(int i = 0; i < word1.length(); i++){
            Character currChar1 = word1.charAt(i);
            if(!word1Map.containsKey(currChar1)){
                word1Map.put(currChar1, 1);
            }
            else{
                word1Map.put(currChar1, word1Map.get(currChar1) + 1);
            }

            Character currChar2 = word2.charAt(i);
            if(!word2Map.containsKey(currChar2)){
                word2Map.put(currChar2, 1);
            }
            else{
                word2Map.put(currChar2, word2Map.get(currChar2) + 1);
            }
        }

        int[] vals1 = new int[word1Map.size()];
        int[] vals2 = new int[word2Map.size()];
        int count = 0;
        for(char key : word1Map.keySet()){
            vals1[count] = word1Map.get(key);
            count++;
        }
        count = 0;
        for(char key : word2Map.keySet()){
            vals2[count] = word2Map.get(key);
            count++;
        }
        Arrays.sort(vals1);
        Arrays.sort(vals2);

        System.out.println(Arrays.toString(vals1));
        System.out.println(Arrays.toString(vals2));

        return Arrays.equals(vals1, vals2);
    }

    public static boolean closeStrings3(String word1, String word2){
        if(word1.length() != word2.length()) return false;
        int[] word1Arr = new int[26]; // 26 lowercase alphabet (0-25)
        int[] word2Arr = new int[26];
        for(int i = 0; i < word1.length(); i++){
            // using ascii value and index of array in storing freq of letters
            // (0-a...25-z)
            word1Arr[word1.charAt(i) - 'a'] += 1;
            word2Arr[word2.charAt(i) - 'a'] += 1;
        }
        System.out.println(Arrays.toString(word1Arr));
        System.out.println(Arrays.toString(word2Arr));
        for(int j = 0; j < word1Arr.length; j++){
            if((word1Arr[j] != 0 && word2Arr[j] == 0) || (word1Arr[j] == 0 && word2Arr[j] != 0)) return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>(); // create a map for storing word1Arr
        for (int i = 0; i < 26; i++) {
            map.put(word1Arr[i], map.getOrDefault(word1Arr[i], 0) + 1);
            // adds the values of wordArr1 as keys of the map
            // defaults to zero if key is not exists in the map, else get the value
            // then adds 1 to the value of the key

            map.put(word2Arr[i], map.getOrDefault(word2Arr[i], 0) - 1);
            // adds the values of wordArr2 as keys of the map
            // defaults to zero if key is not exists in the map, else get the value
            // then subtracts 1 to the value of the key
        }
        // all values in the map should be 0 if all numbers of wordArr1 is present in wordArr2 and vice versa
        // (or they are equal when sorted)
        System.out.println(map);
        for (var key: map.keySet()) { // loop through the keyset of the map
            if (map.get(key) != 0) { // check for any value that are not equal to 0
                return false;
            }
        }
        return true;

    }

    public static void testCloseStrings(){
        String word1 = "cabbba";
        String word2 = "abbccc";
//        String word1 = "abbzzca";
//        String word2 = "babzzcz";
        System.out.println(closeStrings3(word1, word2));
    }
}
