import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _739 {
    public static void main(String[] args) {

    }
}

class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            //如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                int temp = deque.pop();
                result[temp] = i - temp;
            }
            deque.push(i);
        }

        return result;
    }
}
