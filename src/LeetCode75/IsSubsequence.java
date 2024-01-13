package LeetCode75;

import java.util.Arrays;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            int charIndex = t.indexOf(s.charAt(i));
            if(charIndex == -1){
                return false;
            }
            else{
                t = t.substring(charIndex + 1);
            }
        }
        return true;
    }

    public static void testIsSubsequence(){
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(IsSubsequence.isSubsequence(s, t));
    }
}
