import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515 {
    public static void main(String[] args) {

    }
}

class Solution_515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;

            while (len > 0) {
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }

            result.add(max);
        }

        return result;
    }
}
