package LeetCode75;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static int maxVowels(String s, int k) {
        int vowelCount = 0; // stores the vowel count of sub-array
        String vowels = "aeiou";
        for(int i = 0; i < k; i++){ // processing the first sub-array which will also serve as the basis for the following arrays
            if(vowels.indexOf(s.charAt(i)) != -1){ // check if current character is a vowel
                vowelCount++;
            }
        }
        int maxVowels = vowelCount; // begin with setting the first vowel count as the highest
        for(int j = 1; j < s.length() - k + 1; j++){
            int prevHead = vowels.indexOf(s.charAt(j - 1));
            int currTail = vowels.indexOf(s.charAt(j + k - 1));
            if(prevHead == -1 && currTail != -1){ // not vowel && vowel
                vowelCount++;
            }
            else if(prevHead != -1 && currTail == -1){ // vowel && not vowel
                vowelCount --;
            }
            // vowelCount's value will remain for (vowel && vowel) AND (not vowel && not vowel)
            maxVowels = Math.max(maxVowels, vowelCount); // get the highest vowel count
        }
        return maxVowels;
    }

    public static void testMaxVowels(){
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));

        s = "leetcode";
        k = 4;
        System.out.println(maxVowels(s, k));
    }
}
