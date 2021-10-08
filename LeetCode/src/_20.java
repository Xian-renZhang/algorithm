import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _20 {
    public static void main(String[] args) {
        Solution_20 solution = new Solution_20();
        System.out.println(solution.isValid("){"));
    }
}

class Solution_20 {

    //region version 1
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        int index = 0;

        while (index < len) {
            switch (s.charAt(index)) {
                case '(', '[', '{' -> stack.push(s.charAt(index));
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
            }
            ++index;
        }

        return stack.isEmpty();
    }
    //endregion

    //region version 2
    public boolean isValid_v2(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') {
                deque.push(')');
            } else if (ch == '[') {
                deque.push(']');
            } else if (ch == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            } else {
                deque.pop();
            }
        }

        return deque.isEmpty();
    }
    //endregion

}
