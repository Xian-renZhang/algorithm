import java.util.Stack;

public class _232 {
}

class MyQueue {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> auxiStack;

    public MyQueue() {
        mainStack = new Stack<>();
        auxiStack = new Stack<>();
    }

    public void push(int x) {
        if (mainStack.isEmpty()) {
            mainStack.push(x);
        } else {
            while (!mainStack.isEmpty()) {
                auxiStack.push(mainStack.pop());
            }
            mainStack.push(x);
            while (!auxiStack.isEmpty()) {
                mainStack.push(auxiStack.pop());
            }
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
