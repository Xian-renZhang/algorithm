import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            //队列头结点需要在[i - k + 1, i]范围内，不符合则弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            //保证每次放进去的数字要比末尾的都大，否则也弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }

        return res;
    }
}
