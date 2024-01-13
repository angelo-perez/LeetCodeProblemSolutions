package LeetCode75;

import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> listOfList = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        // loops for converting nums1 and nums2 in sets
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }


        HashSet<Integer> set3 = new HashSet<>(set1); // create a temporary original copy of set1
        set1.removeAll(set2); // remove all elements of set1 that exists in set2
        set2.removeAll(set3); // remove all elements of set2 that exists in set3 (original copy of set1)

        System.out.println(set1);
        System.out.println(set2);

        // converting the set1 and set2 into ArrayLists and adding to the listOfLists
        listOfList.add(new ArrayList<>(set1));
        listOfList.add(new ArrayList<>(set2));

        return listOfList;
    }

    public static void testfindDifference(){
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{2,4,6};
        System.out.println(findDifference(nums1, nums2));
    }
}
