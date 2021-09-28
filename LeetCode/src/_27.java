public class _27 {
    public static void main(String[] args) {
        Solution_27 solution = new Solution_27();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(solution.removeElement(nums, val));
    }
}

class Solution_27 {

    //region version 1
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                ++left;
            } else {
                nums[left] = nums[right--];
            }
        }
        return left;
    }
    //endregion

    //region version 2 快慢指针：不改变元素的相对位置
    //相当于在原数组头部开辟一个新数组，只依次放入符合要求的元素
    public int removeElement_v2(int[] nums, int val) {
        int fastIndex = 0, slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }
    //endregion

}