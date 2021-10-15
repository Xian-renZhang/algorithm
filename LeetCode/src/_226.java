import java.util.LinkedList;
import java.util.Queue;

public class _226 {
    public static void main(String[] args) {

    }
}

class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (left != null) queue.add(left);
            if (right != null) queue.add(right);
        }

        return root;
    }
}
