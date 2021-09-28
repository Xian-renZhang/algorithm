import java.util.Arrays;

public class _135 {
    public static void main(String args[]) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        Solution_135 solution = new Solution_135();
        System.out.println("total: " + solution.candy_ver_2(ratings));
    }
}

class Solution_135 {

    //region version 1
    public int candy(int[] ratings) {
        int num = 0;
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum, 1);

        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                if (ratings.length == 1) {
                    break;
                }
                if (ratings[i] > ratings[i + 1]) {
                    ++candyNum[i];
                }
                continue;
            }
            if (i == ratings.length - 1) {
                candyNum[i] = ratings[i] > ratings[i - 1] ? candyNum[i - 1] + 1 : 1;
                continue;
            }
            if (ratings[i] > ratings[i - 1]) {
                while (candyNum[i] <= candyNum[i - 1]) {
                    ++candyNum[i];
                }
            }
            if (ratings[i] > ratings[i + 1]) {
                if (candyNum[i] == candyNum[i + 1]) {
                    ++candyNum[i];
                    for (int j = i; j >= 1; j--) {
                        if (ratings[j] < ratings[j - 1] && candyNum[j - 1] == candyNum[j]) {
                            ++candyNum[j - 1];
                        }
                    }
                }
            }

        }

        for (int item : candyNum) {
            System.out.println(item);
            num += item;
        }
        return num;
    }

    //endregion

    //region version 2
    public int candy_ver_2(int[] ratings) {
        int length = ratings.length;
        if (length == 1) {
            return length;
        }
        int[] candyNum = new int[length];
        Arrays.fill(candyNum, 1);
        //从左往右遍历，如果右边孩子评分高，则右边孩子糖果数为左边加 1
        for (int i = 1; i < length; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;
            }
        }
        //从右往左遍历，如果左边孩子评分高且当前糖果数不大于右边孩子，则左边孩子糖果数为右边加 1
        for (int i = length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1]) {
                candyNum[i] = Math.max(candyNum[i], candyNum[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int item : candyNum) {
            sum += item;
        }
        return sum;
    }
    //endregion

}
