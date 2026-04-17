package leetCode.listNode;
// K个一组翻转链表



public class internalSwap2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = prev.next;
        ListNode start = dummy;
        ListNode end,first,last;
        while (true) {
            int count = 0;
            first = start.next;
            ListNode next =start;
            while (next.next != null && count < k) {
                next = next.next;
                count++;
            }
            if (count == k) {
                last = next;
                end = last.next;
                ListNode temp;
                for (int i = 0; i < k; i++) {
                    temp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = temp;
                }
                start.next = last;
                first.next = end;
                start = first;
            } else {
                break;
            }
        }
        return dummy.next;
    }
}
