package leetCode.listNode.caculate;

import leetCode.listNode.ListNode;

// 链表最大孪生和
public class NodePairMax {
    public int pairSum(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode head2 = reverse(mid);

        int ans = 0;
        while(head2!=null){
            ans=Math.max(ans, head.val+head2.val);
            head=head.next;
            head2=head2.next;
        }
        return ans;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
