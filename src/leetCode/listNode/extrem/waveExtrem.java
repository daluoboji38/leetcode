package leetCode.listNode.extrem;

import leetCode.listNode.ListNode;

// 找出临界点之间的最小和最大距离
public class waveExtrem {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first=0;
        int pre=Integer.MIN_VALUE/2;
        int minDis=Integer.MAX_VALUE;
        ListNode a=head;
        ListNode b=head.next;
        ListNode c=head.next.next;

        for(int i=1;c!=null;i++){
            if(a.val<b.val && b.val>c.val || a.val>b.val && b.val<c.val){
                if(first==0){
                    first=i;
                }
                minDis=Math.min(minDis,i-pre);
                pre=i;
            }
            a=b;
            b=c;
            c=c.next;
        }

        if(first>=pre)return new int[]{-1,-1};
        return new int[]{minDis,pre-first};
    }

}
