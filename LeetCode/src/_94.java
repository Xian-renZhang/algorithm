import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _94 {
    public static void main(String[] args) {

    }
}

class Solution_94 {

    //region 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
    //endregion

    //region 迭代
    public List<Integer> inorderTraversal_iteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            //尽可能将该节点的左子树压栈
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }

            TreeNode node = deque.pop();
            list.add(node.val);
            //如果该节点有右子树，切换到右子树
            if (node.right != null) {
                cur = node.right;
            }
        }

        return list;
    }
    //endregion

}
