public class _28 {
    public static void main(String[] args) {
        Solution_28 solution = new Solution_28();
        solution.strStr("mississippi", "issip");
    }
}

class Solution_28 {

    //region version 1
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int headIndex = 0;
        int tailIndex = 0;
        int subIndex = 0;
        boolean flag = false;

        while (tailIndex < haystack.length() && headIndex < haystack.length()) {

            if (!flag && haystack.charAt(headIndex) == needle.charAt(subIndex)) {
                tailIndex = headIndex;
                flag = true;
            }

            if (!flag) {
                headIndex++;
                continue;
            }

            if (haystack.charAt(tailIndex) == needle.charAt(subIndex)) {
                tailIndex++;
                subIndex++;
            } else {
                headIndex++;
                subIndex = 0;
                flag = false;
            }

            if (subIndex == needle.length()) {
                return headIndex;
            }
        }

        return -1;
    }
    //endregion

}
