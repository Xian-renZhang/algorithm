import java.util.HashSet;
import java.util.Set;

public class _349 {
    public static void main(String[] args) {

    }
}

class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length
                == 0) {
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        int[] resArray = new int[resSet.size()];
        int index = 0;
        for (int i : resSet) {
            resArray[index++] = i;
        }

        return resArray;
    }
}
