package leetCode.listNode.caculate;

import leetCode.listNode.ListNode;

public class NodePairMaxV2 {
    private static final int[] NODE_VALUES=new int[100000];

    public int pairSum(ListNode head) {
        int nodeIdx=0;
        while(head!=null){
            NODE_VALUES[nodeIdx++]=head.val;
            head=head.next;
        }
        int ans=0;
        int bound=nodeIdx/2;
        int maxIndex=nodeIdx-1;
        for(int i=0;i<bound;i++){
            ans=Math.max(ans,NODE_VALUES[maxIndex-i]+NODE_VALUES[i]);
        }
        return ans;
    }
}
