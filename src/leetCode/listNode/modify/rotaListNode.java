package leetCode.listNode.modify;

import leetCode.listNode.ListNode;

// 旋转链表
public class rotaListNode {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = getLength(head);
        if (k % length == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        for (int i = 0; i < length - k % length; i++) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = null;
        ListNode newHead = curr;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
