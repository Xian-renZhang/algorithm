public class Offer58_2 {
}

class Solution {
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, length - 1);
        reverseString(sb, 0, length - 1);
        return sb.toString();
    }

    private void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
