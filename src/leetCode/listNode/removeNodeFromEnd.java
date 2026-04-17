package leetCode.listNode;
// 删除链表的倒数第N个节点


public class removeNodeFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for(int i=0; i<length-n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head){
        int length = 0;
        while(head!= null){
            length++;
            head = head.next;
        }
        return length;
    }
}
