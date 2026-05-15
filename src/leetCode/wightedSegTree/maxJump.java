package leetCode.wightedSegTree;

import java.util.Arrays;

// 达到末尾下标所需的最大跳跃次数
public class maxJump {
    private int[] tree;

    private void update(int node,int l,int r,int i,int val){
        if(l==r){
            tree[node]=val;
            return;
        }
        int m=(l+r)/2;
        if(i<=m){
            update(node * 2,l,m,i,val);
        }else{
            update(node * 2 + 1,m + 1,r,i,val);
        }
        tree[node]=Math.max(tree[node * 2],tree[node * 2 + 1]);
    }


    private int query(int node,int l,int r,int ql,int qr){
        if(ql<=l&&r<=qr){
            return tree[node];
        }
        int m=(l+r)/2;
        if(qr<=m){
            return query(node *2,l,m,ql,qr);
        }
        else if(ql>m){
            return query(node * 2 + 1,m + 1,r,ql,qr);
        }
        return Math.max(query(node * 2,l,m,ql,qr),query(node * 2 + 1,m + 1,r,ql,qr));
    }


    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] sorted=nums.clone();
        Arrays.sort(sorted);

        tree=new int[4*n];
        Arrays.fill(tree,Integer.MIN_VALUE);

        update(1,0,n-1,lowerBound(sorted,nums[0]),0);

        for(int j=1;;j++){
        int l=lowerBound(sorted,(long)nums[j]-target);
        int r=lowerBound(sorted,(long)nums[j]+target+1)-1;
        int fj=query(1,0,n-1,l,r)+1;
        if(j==n-1){
            return fj<0? -1 : fj;
        }
        update(1,0,n-1,lowerBound(sorted,nums[j]),fj);
        }
    }


    private int lowerBound(int[] nums,long target){
        int left=-1;
        int right=nums.length;
        while(left+1<right){
            int mid=(left+right) >>> 1;
            if(nums[mid]>=target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
}
