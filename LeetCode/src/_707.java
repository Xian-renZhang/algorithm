public class _707 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3

    }
}

class MyLinkedList {

    class ListNode {
        int val;
        ListNode next, prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    int size;
    ListNode head, tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode cur = head;

        if (index < (size - 1) / 2) {
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        } else {
            cur = tail;
            for (int i = 0; i <= size - index - 1; i++) {
                cur = cur.prev;
            }
        }

        return cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode cur = head;
        ListNode node = new ListNode(val);
        //依次考虑一对节点之间的指向关系
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
        node.prev = cur;
        ++size;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode cur = tail;
        ListNode node = new ListNode(val);

        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
        node.next = cur;
        ++size;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            index = 0;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode node = new ListNode(val);
        node.next = cur.next;
        cur.next.prev = node;
        node.prev = cur;
        cur.next = node;
        ++size;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        --size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
