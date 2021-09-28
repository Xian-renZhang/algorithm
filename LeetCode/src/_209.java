import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _209 {
    public static void main(String[] args) {
        Solution_209 solution = new Solution_209();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}

class Solution_209 {

    //region version 1
    public int minSubArrayLen(int target, int[] nums) {
        int slowIndex = 0, fastIndex = 0;
        int total = 0;

        if (Arrays.binarySearch(nums, target) >= 0) {
            return 1;
        }

        ArrayList<Integer> length = new ArrayList<>();

        while (slowIndex <= nums.length) {
            if (total >= target) {
                length.add(fastIndex - slowIndex);
                total -= nums[slowIndex++];
            } else {
                if (fastIndex == nums.length) {
                    break;
                }
                total += nums[fastIndex++];
            }
        }

        return length.isEmpty() ? 0 : Collections.min(length);
    }
    //endregion

    //region version 2 滑动窗口
    public int minSubArrayLen_v2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            result = Math.min(result, right - left + 1);
            sum -= nums[left++];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    //endregion

    //region version 3
    public int minSubArrayLen_v3(int target, int[] nums) {
        int slowIndex = 0, fastIndex = 0;
        int total = 0;
        int result = Integer.MAX_VALUE;

        if (Arrays.binarySearch(nums, target) >= 0) {
            return 1;
        }

        while (slowIndex <= nums.length) {
            if (total >= target) {
                result = Math.min(result, fastIndex - slowIndex);
                total -= nums[slowIndex++];
            } else {
                if (fastIndex == nums.length) {
                    break;
                }
                total += nums[fastIndex++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
    //endregion
}
