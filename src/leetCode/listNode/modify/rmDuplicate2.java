package leetCode.listNode.modify;

import leetCode.listNode.ListNode;

// 删除排序链表中的重复元素 II
public class rmDuplicate2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode root = new ListNode(101, cur);

        ListNode pre = root;
        while (cur.next != null && cur==head) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if(cur.next == null){
                    root.next = null;
                }else {
                    cur = cur.next;
                    root.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                if(cur.next == null){
                    pre.next = null;
                }else {
                    cur = cur.next;
                    pre.next = cur;
                }
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }
}
