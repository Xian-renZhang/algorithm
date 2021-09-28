public class _704 {
    public static void main(String[] args) {
        Solution_704 solution = new Solution_704();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        System.out.println(solution.search(nums, target));
    }
}

class Solution_704 {

    //region version 1
    public int search(int[] nums, int target) {

        int high = nums.length - 1;
        int low = 0;
        int middle = 0;

        while (low <= high) {
            middle = (high + low) / 2;
            if (target < nums[middle]) {
                high = middle - 1;
                continue;
            }
            if (target > nums[middle]) {
                low = middle + 1;
                continue;
            }
            break;
        }

        return low <= high ? middle : -1;
    }
    //endregion

    //region version 2
    public int search_v2(int[] nums, int target) {
        //避免特殊情况下多次循环
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
    //endregion

}
