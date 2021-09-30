import java.util.LinkedList;
import java.util.Queue;

public class _225 {
}

class MyStack {

    private Queue<Integer> mainQueue;
    private Queue<Integer> auxiQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        auxiQueue = new LinkedList<>();
    }

    public void push(int x) {
        auxiQueue.offer(x);
        while (!mainQueue.isEmpty()) {
            auxiQueue.offer(mainQueue.poll());
        }
        Queue<Integer> temp = auxiQueue;
        auxiQueue = mainQueue;
        mainQueue = temp;
    }

    public int pop() {
        return mainQueue.poll();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
