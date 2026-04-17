package leetCode.listNode.divideNConquer;
// 合并k个升序链表

import leetCode.listNode.ListNode;
// divide and conquer
public class mergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        int m = lists.length;
        if (m == 0) return null;
        for(int step=1; step<m; step<<=1){
            for(int i=0; i<m-step; i+=step<<1){
                lists[i] = mergeTwoLists(lists[i], lists[i+step]);
                }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1!= null && l2!= null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
