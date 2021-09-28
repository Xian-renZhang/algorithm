public class _24 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution_24 solution = new Solution_24();
        solution.swapPairs(node1);
    }
}

class Solution_24 {

    //region version 1
    public ListNode swapPairs(ListNode head) {
        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-2);
        ListNode oddTemp = oddList;
        ListNode evenTemp = evenList;
        ListNode temp = head;
        int count = 1;

        while (temp != null) {
            if (count % 2 == 0) {
                evenTemp.next = temp;
                evenTemp = evenTemp.next;
            } else {
                oddTemp.next = temp;
                oddTemp = oddTemp.next;
            }
            ++count;
            temp = temp.next;
        }
        oddTemp.next = null;
        evenTemp.next = null;

        oddTemp = oddList.next;
        evenTemp = evenList.next;
        ListNode list = new ListNode(-3);
        temp = list;
        count = 1;

        while (oddTemp != null && evenTemp != null) {
            if (count % 2 == 0) {
                temp.next = oddTemp;
                oddTemp = oddTemp.next;
            } else {
                temp.next = evenTemp;
                evenTemp = evenTemp.next;
            }
            temp = temp.next;
            ++count;
        }

        temp.next = oddTemp == null ? evenTemp : oddTemp;
        return list.next;
    }
    //endregion

    //region version 2
    public ListNode swapPairs_v2(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }

        return dummyNode.next;
    }
    //endregion
}
