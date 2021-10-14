import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429 {
    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution_429 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();

            while (len > 0) {
                Node node = queue.remove();
                temp.add(node.val);

                if (node.children == null || node.children.size() == 0) {
                    len--;
                    continue;
                }
                for (Node child : node.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
                len--;
            }

            result.add(temp);
        }

        return result;
    }
}
