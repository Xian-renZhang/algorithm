import java.util.ArrayList;

public class _142 {
    public static void main(String[] args) {

    }
}

class Solution_142 {

    //region version 1
    public ListNode detectCycle(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;

        while (cur != null) {
            if (!list.contains(cur)) {
                list.add(cur);
                cur = cur.next;
            } else {
                return cur;
            }
        }

        return null;
    }
    //endregion

    //region version 2
    public ListNode detectCycle_v2(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                slowNode = head;
                while (slowNode != fastNode) {
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return slowNode;
            }
        }

        return null;
    }
    //endregion

}
