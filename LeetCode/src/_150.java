import java.util.Deque;
import java.util.LinkedList;

public class _150 {
    public static void main(String[] args) {

    }
}

class Solution_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> deque.push(deque.pop() + deque.pop());
                case "-" -> deque.push(-deque.pop() + deque.pop());
                case "*" -> deque.push(deque.pop() * deque.pop());
                case "/" -> {
                    int temp = deque.pop();
                    deque.push(deque.pop() / temp);
                }
                default -> deque.push(Integer.valueOf(token));
            }
        }

        return deque.pop();
    }
}
