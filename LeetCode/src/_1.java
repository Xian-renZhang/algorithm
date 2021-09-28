import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1 {
    public static void main(String[] args) {

    }
}

class Solution_1 {

    //region version 1
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        int num1 = 0, num2 = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : set) {
            int part = target - i;
            if (set.contains(part)) {
                num1 = i;
                num2 = part;
                break;
            }
        }
        int[] res = new int[2];
        int index = 1;
        for (int i = 0; i < nums.length && index >= 0; i++) {
            if (nums[i] == num1 || nums[i] == num2) {
                res[index--] = i;
            }
        }
        return res;
    }
    //endregion

    //region version 2
    public int[] twoSum_v2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }

        return res;
    }
    //endregion

}
