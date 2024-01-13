package LeetCode75;

import java.util.Stack;

public class RemovingStarsFromString {
    public static String removeStarsUsingStack(String s) {
        Stack<Character> chrStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar != '*'){
                chrStack.push(currChar);
            }
            else{
                chrStack.pop();
            }
        }
        System.out.println(chrStack);
        StringBuilder sb = new StringBuilder();
        for(char chr : chrStack){
            sb.append(chr);
        }
        return sb.toString();
    }

    public static String removeStarsUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '*'){
                sb.delete(sb.length() - 1, sb.length());
            }
            else {
                sb.append(currChar);
            }
        }
        return sb.toString();
    }

    public static void testRemoveStars(){
        String s = "leet**cod*e";
        //System.out.println(removeStarsUsingStringBuilder(s));
        System.out.println(removeStarsUsingStack(s));

        s = "erase*****";
        //System.out.println(removeStarsUsingStringBuilder(s));
        System.out.println(removeStarsUsingStack(s));
    }
}
