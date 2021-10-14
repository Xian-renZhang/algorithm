import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102 {
    public static void main(String[] args) {

    }
}

class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                len--;
            }

            result.add(temp);
        }

        return result;
    }
}
