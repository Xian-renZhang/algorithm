import java.util.*;

public class _145 {
    public static void main(String[] args) {

    }
}

class Solution_145 {

    //region 递归
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
    //endregion

    //region 迭代
    public List<Integer> postorderTraversal_iteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return list;
        }

        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            list.add(node.val);
            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }
        }

        Collections.reverse(list);
        return list;
    }
    //endregion

}

