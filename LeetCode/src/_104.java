import java.util.LinkedList;
import java.util.Queue;

public class _104 {
    public static void main(String[] args) {

    }
}

class Solution_104 {

    //region 迭代
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            depth++;
        }

        return depth;
    }
    //endregion

    //region 递归
    public int maxDepth_recur(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftHeight = maxDepth_recur(root.left);
            int rightHeight = maxDepth_recur(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    //endregion

}
