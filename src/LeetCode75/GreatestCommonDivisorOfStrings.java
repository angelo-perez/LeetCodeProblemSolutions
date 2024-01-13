package LeetCode75;

public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if((str1 + str2).equals(str2 + str1)){ //e.g. str1 = abcabc, str2 = abc, therefore, str1 + str2 = abcabcabc = str2 + str1
            int shorterStr = Math.min(str1.length(), str2.length());
            int gcf = 0;
            for(int i = 1; i <= shorterStr; i++){
                if(str1.length()%i == 0 && str2.length()%i == 0){
                    gcf = Math.max(gcf, i);
                }
            }
            return str1.substring(0, gcf);
        }
        else{
            return "";
        }
    }

    public static void testGcdOfStrings(){
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));

        str1 = "ABABAB";
        str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2));

        str1 = "ABCDEF";
        str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2));
    }
}
