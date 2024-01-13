package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseVowelsOfAString {

    public static String reverseVowelsUsingTwoPointer(String s) { // more efficient (mine)
        char[] sArr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int left = 0;
        int right = sArr.length - 1;
        while(left <= right){
            boolean isVowelOnLeft = vowels.indexOf(sArr[left]) != -1;
            boolean isVowelOnRight = vowels.indexOf(sArr[right]) != -1;
            if(isVowelOnLeft && isVowelOnRight){
                char tempChar = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = tempChar;
                left++;
                right--;
            }
            else if(isVowelOnLeft && !isVowelOnRight){
                right--;
            } else if (isVowelOnRight && !isVowelOnLeft) {
                left++;
            }
            else {
                left++;
                right--;
            }
        }
        return new String(sArr);
    }

    public static String reverseVowelsUsingTwoPointer2(String s) { // most efficient (not mine)
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Move the pointers towards each other
            start++;
            end--;
        }

        String answer = new String(word);
        return answer;
    }

    public static String reverseVowels(String s) { // least efficient
        ArrayList<Character> arrVowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        ArrayList<Integer> vowelIndices = new ArrayList<>();
        String revVowels = "";
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(arrVowels.contains(Character.toLowerCase(currChar))){
                revVowels = Character.toString(currChar) + revVowels;
                vowelIndices.add(i);
            }
        }
        for(int j = 0; j < vowelIndices.size(); j++){
            s = s.substring(0, vowelIndices.get(j)) + Character.toString(revVowels.charAt(j)) +  s.substring(vowelIndices.get(j) + 1);
        }
        return s;
    }

    public static void testReverseVowel(){
        String s = "hello";
        System.out.println(reverseVowelsUsingTwoPointer(s));

        s = "headed";
        System.out.println(reverseVowelsUsingTwoPointer(s));

        s = "leetcode";
        System.out.println(reverseVowelsUsingTwoPointer(s));

        s = "A man, a plan, a canal: Panama";
        System.out.println(reverseVowelsUsingTwoPointer(s));
    }
}
