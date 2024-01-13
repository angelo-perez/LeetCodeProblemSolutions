package csjodo_dsa;

import java.util.Arrays;

public class QuickSort {
    public static int partition(int[] arr, int l, int r){
        int pivot = arr[r];
        int i = l - 1;
        for(int j = l; j <= r - 1; j++){
            if(arr[j] < pivot){
                i++;
                int tempJ = arr[j];
                arr[j] = arr[i];
                arr[i] = tempJ;
            }
        }
        int tempPivot = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = tempPivot;
        //System.out.println(Arrays.toString(arr));
        return i + 1;
    }

    public static void quicksort(int[] arr, int l, int r){
        if(l >= r){
            //System.out.println(Arrays.toString(arr));
            return;
        }
        int p = partition(arr, l, r);
        quicksort(arr, l, p - 1);
        quicksort(arr, p + 1, r);
    }

    public static void testQuicksort(){
        int[] arr = {-2, 3, -1, 5, 4, -3, 0};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
