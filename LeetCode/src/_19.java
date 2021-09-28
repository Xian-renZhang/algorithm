public class _19 {
    public static void main(String[] args) {

    }
}

class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode fastNode = dummyNode;
        ListNode slowNode = dummyNode;
        int count = 0;

        while (n-- >= 0) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return dummyNode.next;
    }
}
