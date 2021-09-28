public class _203 {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution_203 {

    //region version 1
    public ListNode removeElements(ListNode head, int val) {
        ListNode _head = new ListNode();
        _head.next = head;

        ListNode p = _head;

        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            }
            if (p.next != null && p.next.val != val) {
                p = p.next;
            }
        }

        return _head.next;
    }
    //endregion

    //region version 2
    public ListNode removeElements_v2(ListNode head, int val) {
        ListNode _head = new ListNode(-1, head);

        //双指针
        ListNode pre = _head;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return _head.next;
    }
    //endregion
}