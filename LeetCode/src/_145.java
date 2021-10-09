import java.util.ArrayList;
import java.util.List;

public class _145 {
    public static void main(String[] args) {

    }
}

class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }
}

