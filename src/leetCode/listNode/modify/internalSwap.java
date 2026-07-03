package leetCode.listNode.modify;
// 两两交换链表中的节点


import leetCode.listNode.ListNode;

public class internalSwap {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // 0p1
        ListNode curr = head; // 1p2
        while (curr != null && curr.next != null) {
            ListNode next = curr.next; // 2p3
            prev.next = next; // 0p2
            curr.next = next.next; // 1p3
            next.next = curr; // 2p1
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}
