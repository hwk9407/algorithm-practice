class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            int before = i == 0 ? 0 : i - 1;
            int after = i == len - 1 ? i : i + 1;
            if (flowerbed[i] == 0 && flowerbed[before] == 0 && flowerbed[after] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            if (n == 0) break;
        }
        
        return !(n > 0);
    }
}