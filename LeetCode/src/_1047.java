import java.util.Deque;
import java.util.LinkedList;

public class _1047 {
    public static void main(String[] args) {

    }
}

class Solution_1047 {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (!deque.isEmpty() && deque.getFirst() == ch) {
                deque.removeFirst();
            } else {
                deque.addFirst(ch);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.removeLast());
        }

        return res.toString();
    }
}
