package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        ArrayList<String> uniqueChar = new ArrayList<String>();
        uniqueChar.add("");
        int initialStrLen = 0;
        String longUniqChar = "";
        int jstart = 0;
        outerloop:
        for(int i = 0; i < s.length(); i++){ // for each character of givenString
            String givenChar = s.substring(i, i+1);
            innerloop:
            for(int j = jstart; j < uniqueChar.size(); j++){
                if(uniqueChar.get(j).contains(givenChar)){
                    uniqueChar.add(givenChar);
                    jstart++;
                    continue outerloop;
                }
                else {
                    String newStr = uniqueChar.get(j) + givenChar;
                    uniqueChar.set(j, newStr);
                }
            }
        }

        for(String str : uniqueChar){
            if(str.length() > initialStrLen){
                initialStrLen = str.length();
                longUniqChar = str;
            }
        }

        System.out.println(longUniqChar);
        return initialStrLen;
    }

    public static int newLengthOfLongestSubstring(String s){
        HashSet<String> uniqueLetters = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while(right < s.length()){
            String currChar = s.substring(right, right+1);
            if(!uniqueLetters.contains(currChar)){ //right pointer
                uniqueLetters.add(currChar);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            else{ // left pointer
                while(right != left && uniqueLetters.contains(currChar)){
                    uniqueLetters.remove(s.substring(left, left+1));
                    left++;
                }
            }
        }

        System.out.println(uniqueLetters);
        return maxLength;
    }

    public static void testlengthOfLongestSubstring(){
        String str = "abcabcbb";
        System.out.println(newLengthOfLongestSubstring(str));
        str = "bbbbb";
        System.out.println(newLengthOfLongestSubstring(str));
        str = "pwwkew";
        System.out.println(newLengthOfLongestSubstring(str));
        str = "dvdf";
        System.out.println(newLengthOfLongestSubstring(str));
    }
}
