public class _605 {
    public static void main(String[] args) {
        Solution_605 solution = new Solution_605();
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(solution.canPlaceFlowers(flowerbed, n));
    }
}

class Solution_605 {

    //region version 1
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean flag = true;
        for (int i = 0; i < flowerbed.length - 1; i++) {
            if(i==0&&flowerbed[i+1]==0){
                --n;
                flag=false;
                continue;
            }
            if (flowerbed[i] == 1) {
                flag = false;
                continue;
            }
            if (flag) {
                if (flowerbed[i + 1] == 0) {
                    --n;
                    flag = false;
                    continue;
                }
            }
            flag = true;
        }
        if (flag && flowerbed[flowerbed.length - 1] == 0) {
            --n;
        }
        return n <= 0;
    }
    //endregion

}
