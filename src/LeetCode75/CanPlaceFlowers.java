package LeetCode75;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }
        for(int i = 0; i < flowerbed.length; i++){
            // checks if there's a slot (001, 000, 100) AND if current plot is the start or last
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length - 1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1; // plants the flower to the open slot
                n--; // reduces the flowers that are needed to be planted
                if(n == 0){ // checks if there's nothing to be planted already
                    return true;
                }
            }
        }
        return false;
    }

    public static void testCanPlaceFlowers(){
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));

        flowerbed = new int[]{1, 0, 1, 0, 1, 0, 1};
        n = 0;
        System.out.println(canPlaceFlowers(flowerbed, n));

        flowerbed = new int[]{1, 0, 0, 0, 0, 0, 1};
        n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
