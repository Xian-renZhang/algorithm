import java.util.HashMap;
import java.util.Map;

public class _454 {
    public static void main(String[] args) {

    }
}

class Solution_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }

        return res;
    }
}
