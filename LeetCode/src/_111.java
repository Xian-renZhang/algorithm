import java.util.LinkedList;
import java.util.Queue;

public class _111 {
    public static void main(String[] args) {

    }
}

class Solution_111 {

    //region 迭代
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            depth++;
            while (len > 0) {
                TreeNode node = queue.remove();
                if (node.left == null && node.right == null) return depth;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
        }

        return depth;
    }
    //endregion

    //region 递归
    public int minDepth_recur(TreeNode root) {
        if (root == null) return 0;
        else {
            int leftHeight = minDepth_recur(root.left);
            int rightHeight = minDepth_recur(root.right);
            // 如果左子树或右子树的深度不为0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
            // 如果左子树和右子树的深度都不为0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
            return (leftHeight == 0 || rightHeight == 0) ? leftHeight + rightHeight + 1 : Math.min(leftHeight, rightHeight) + 1;
        }
    }
    //endregion

}
