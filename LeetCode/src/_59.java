public class _59 {
    public static void main(String[] args) {

    }
}

class Solution_59 {

    //region version 1
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        //循环次数
        int loop = n / 2;

        //每次循环起始位置
        int startX = 0;
        int startY = 0;

        //偏移量（即跳过的单元数，每次填充左闭右开）
        int offset = 1;

        //填充数字
        int count = 1;

        //中间位置
        int mid = n / 2;

        while (loop > 0) {
            int i = startX;
            int j = startY;

            //模拟上侧从左到右
            for (; j < startY + n - offset; j++) {
                result[startX][j] = count++;
            }

            //模拟右侧从上到下
            for (; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }

            //模拟下侧从右到左
            for (; j > startY; j--) {
                result[i][j] = count++;
            }

            //模拟左侧从下到上
            for (; i > startX; i--) {
                result[i][j] = count++;
            }

            //沿对角线递进
            startX += 1;
            startY += 1;
            //每次左右/上下少填充两列/行
            offset += 2;

            loop--;
        }
        if (n % 2 == 1) {
            result[mid][mid] = count;
        }

        return result;
    }
    //endregion

}