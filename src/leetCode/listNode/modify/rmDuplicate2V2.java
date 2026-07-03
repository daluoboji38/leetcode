package leetCode.listNode.modify;

import leetCode.listNode.ListNode;

public class rmDuplicate2V2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode uniq=new ListNode(101);
        ListNode dup=new ListNode(101);
        ListNode pUniq=uniq;
        ListNode pDup=dup;
        ListNode p=head;
        while (p!=null){
            if ((p.next!=null && p.val == p.next.val) || p.val==pDup.val){
                pDup.next=p;
                pDup=pDup.next;
            }else {
                pUniq.next=p;
                pUniq=pUniq.next;
            }
            p=p.next;
        }
        pDup.next=null;
        pUniq.next=null;
        return uniq.next;
    }
}
