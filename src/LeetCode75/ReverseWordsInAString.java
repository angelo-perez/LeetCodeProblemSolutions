package LeetCode75;

import java.util.Arrays;

public class ReverseWordsInAString {
    public static String reverseWordsUsingTwoPointer(String s) { // needs improvement for efficiency (mine)
        // USING TWO POINTER ALGO
        s = s.trim();
        StringBuilder revStr = new StringBuilder(); // more efficient way than 'revStr = ""' then concatenating
        int left = 0;
        int right = 0;
        while(left < s.length() && right < s.length()){

            while(!String.valueOf(s.charAt(right)).equals(" ") && right != s.length() - 1){
                right++;
            }

            if(right == s.length() - 1){
                revStr.insert(0, s.substring(left, right + 1));
            }
            else{
                if(!s.substring(left, right).equals("")){
                    revStr.insert(0, s.substring(left, right));
                    revStr.insert(0, " ");
                }
            }

            left = right + 1;
            right++;

        }

        return revStr.toString();
    }

    public static String reverseWordsUsingSplit(String s){ // more efficient
        // USING SPLIT
        s = s.trim();
        String[] wordArr = s.split("\\s+"); // split words in array by using space(s) as separator
        StringBuilder revStr = new StringBuilder(); // more efficient way than 'revStr = ""' then concatenating
        for(int i = wordArr.length - 1; i >= 0; i--){
            if(i == 0){ // checks if it is the first word in reverse and dont add a space
                revStr.append(wordArr[i]);
            }
            else {
                revStr.append(wordArr[i]);
                revStr.append(" ");
            }
        }
        return revStr.toString();
    }

    public static void testReverseWords(){
        String s = "the sky is blue";
        System.out.println(reverseWordsUsingTwoPointer(s));

        s = "the sky is blue";
        System.out.println(reverseWordsUsingSplit(s));
    }
}

