import java.util.Arrays;

public class _455 {
    public static void main(String args[]) {
        Solution_455 solution = new Solution_455();
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(solution.findContentChildren(g, s));
    }
}

class Solution_455 {

    //region version 1
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) ++child;
            ++cookie;
        }
        return child;
    }
    //endregion

}
