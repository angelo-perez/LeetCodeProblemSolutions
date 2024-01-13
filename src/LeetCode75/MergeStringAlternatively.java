package LeetCode75;

public class MergeStringAlternatively {
    public static String mergeAlternately(String word1, String word2) {
        String mergedString = "";
        int longerString = Math.max(word1.length(), word2.length());
        for(int i = 0; i < longerString; i++){
            if(i < word1.length()){
                mergedString += Character.toString(word1.charAt(i));
            }
            if(i < word2.length()){
                mergedString += Character.toString(word2.charAt(i));
            }
        }
        return mergedString;
    }
}
