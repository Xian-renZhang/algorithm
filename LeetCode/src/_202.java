import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class _202 {
    public static void main(String[] args) {
        Solution_202 solution = new Solution_202();
        System.out.println(solution.isHappy(19));
    }
}

class Solution_202 {

    //region version 1
    public boolean isHappy(int n) {
        int record = n;
        while (n > 4) {
            ArrayList<Integer> nums = new ArrayList<>();
            while (n != 0) {
                nums.add(n % 10);
                n = n / 10;
            }
            for (int i : nums) {
                n += i * i;
            }
            if (n == record) {
                break;
            }
        }

        return n == 1;
    }
    //endregion

    //region version 1
    public boolean isHappy_v2(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNum(n);
        }
        return n == 1;
    }

    private int getNextNum(int n) {
        int nextNum = 0;
        while (n > 0) {
            int temp = n % 10;
            nextNum += temp * temp;
            n = n / 10;
        }
        return nextNum;
    }
    //endregion

}
