import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _637 {
    public static void main(String[] args) {

    }
}

class Solution_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0;

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add((sum / len));
        }

        return result;
    }
}
