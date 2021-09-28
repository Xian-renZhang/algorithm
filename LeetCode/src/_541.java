public class _541 {
    public static void main(String[] args) {
        Solution_541 solution = new Solution_541();
        solution.reverseStr("abcdefg", 2);
    }
}

class Solution_541 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);
            //根据344，反转字符串只需确定字符串的首尾，故重点在于确定每一个反转序列的首尾
            //未反转的字符串部分相当于没有处理
            while (start < end) {
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
