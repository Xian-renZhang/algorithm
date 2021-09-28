import java.util.Stack;

public class _151 {
    public static void main(String[] args) {
        Solution_151 solution = new Solution_151();
        solution.reverseWords("a good   example");
    }
}

class Solution_151 {

    //region version 1
    public String reverseWords(String s) {
        s = s.trim();
        s += " ";
        int index = 0;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (" ".equals(String.valueOf(s.charAt(i)))) {
                if (i > 0 && !" ".equals(String.valueOf(s.charAt(i - 1)))) {
                    String str = s.substring(index, i);
                    stack.push(str);
                }
                if (i < s.length() - 2 && !(" ".equals(String.valueOf(s.charAt(i + 1))))) {
                    index = i + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString().trim();
    }
    //endregion

    //region version 2
    public String reverseWords_v2(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (' ' == s.charAt(start)) start++;
        while (' ' == s.charAt(end)) end--;

        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }
    //endregion

}
