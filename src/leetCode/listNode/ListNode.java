package leetCode.listNode;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){}
    public ListNode(int val){this.val = val;}
    public ListNode(int val, ListNode next){this.val = val; this.next = next;}
    public void print() {
        ListNode current = this;
        while (current!= null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
