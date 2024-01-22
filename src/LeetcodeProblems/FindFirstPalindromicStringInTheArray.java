package LeetcodeProblems;

public class FindFirstPalindromicStringInTheArray {
    public static String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(isPalindrome(words[i])) return words[i];
        }
        return "";
    }

    public static boolean isPalindrome(String word){
        int left = 0;
        int right = word.length() - 1;
        while(left<=right){
            if(word.charAt(left) == word.charAt(right)){
                right--;
                left++;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void testFirstPalindrome(){
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }
}
