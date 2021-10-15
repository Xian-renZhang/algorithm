import java.util.LinkedList;
import java.util.Queue;

public class _116 {
    public static void main(String[] args) {

    }
}

class Solution_116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                Node node = queue.remove();
                if (len == 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
        }

        return root;
    }
}
