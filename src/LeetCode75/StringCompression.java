package LeetCode75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCompression {
    public static int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int n = chars.length;
        int charCount = 1;
        for(int i = 0; i < n; i++){
            String currChar = String.valueOf(chars[i]);
            if(s.indexOf(currChar) == -1){
                s.append(currChar);
                charCount = 1;
            }
            else{
                charCount++;
                if(charCount >= 3){
                    s.replace(s.toString().length() - 1, s.toString().length(), Integer.toString(charCount));
                }
                else{
                    s.insert(s.toString().length(), Integer.toString(charCount));
                }
            }
        }
        System.out.println(s.toString());
        return s.toString().length();
    }

    public static int compress2(char[] chars) {
        ArrayList<String> s = new ArrayList<>();
        int n = chars.length;
        int charCount = 1;
        for(int i = 0; i < n; i++){
            String currChar = String.valueOf(chars[i]);
            if(s.indexOf(currChar) == -1){
                s.add(currChar);
                charCount = 1;
            }
            else{
                charCount++;
                if(charCount >= 3){
                    s.set(s.toString().length() - 1, Integer.toString(charCount));
                }
                else{
                    s.set(s.toString().length(), Integer.toString(charCount));
                }
            }
        }
        System.out.println(s.toString());
        return s.toString().length();
    }

    /*
    Given an array of characters chars, compress it using the following algorithm:

    Begin with an empty string s. For each group of consecutive repeating characters in chars:

        - If the group's length is 1, append the character to s.
        - Otherwise, append the character followed by the group's length.

    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

    After you are done modifying the input array, return the new length of the array.

    You must write an algorithm that uses only constant extra space.
    */
    public static int compressUsingTwoPointer(char[] chars){
        int n = chars.length;
        int i = 0; // left pointer starting at 0
        int j; // right pointer initialization
        StringBuilder s = new StringBuilder();
        while(i < n){ // checks if left pointer is still less than the length of array
            j = i + 1; // right pointer starting at left + 1
            while(j < n && chars[i] == chars[j]){ // loops through consecutive repeating character
                j++; // moves the right pointer
            }
            int freq = j - i; // number of consecutive repeating character
            if(j - i > 1){ // check if freq is greater than 1
                s.append(chars[i]); // append the first character of the consecutive repeating character in the StringBuilder
                s.append(freq); // followed by the freq number
                i = j; // left pointer go to the position of the right pointer
            }
            else{ // character is unique and not repeating
                s.append(chars[i]); // append the character to the StringBuilder
                i++; // move left pointer 1 position to the left
            }
        }
        System.out.println(s.toString());
        char[] compressedChars = s.toString().toCharArray();
        for(int l = 0; l < compressedChars.length; l++){
            chars[l] = compressedChars[l]; // copying the contents of compressedChars to the input array (chars)
        }
        System.out.println(Arrays.toString(compressedChars));

        return compressedChars.length;
    }

    public static void testCompress(){
        char[] chars = {'a', 'a', 'a', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c'};
//        System.out.println(compress(chars));.
        System.out.println(compressUsingTwoPointer(chars));


    }
}
