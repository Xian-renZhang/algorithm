import java.util.Arrays;

public class _977 {
    public static void main(String[] args) {
        Solution_977 solution = new Solution_977();
        int[] nums = new int[]{
                -4, -1, 0, 3, 10
        };
        solution.sortedSquares(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

class Solution_977 {
    //region version 1
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
    //endregion

    //region version 2
    public int[] sortedSquares_v2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
    //endregion
}
