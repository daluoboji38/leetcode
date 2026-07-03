package leetCode.listNode.modify;

import leetCode.listNode.ListNode;

// 删除链表的中间节点
public class deleteMid {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
