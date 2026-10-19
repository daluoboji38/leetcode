package leetCode.SegmentTree.arr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 子数组不同元素数目的平方和 I
public class cntSquareSum {
    private long[] sum;
    private int[] todo;
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        sum=new long[n*4];
        todo=new int[n*4];

        long ans = 0,s=0;
        var last=new HashMap<Integer,Integer>();
        for(int i=1;i<=n;i++){
            int x=nums.get(i-1);
            int j=last.getOrDefault(x,0);
            s+=queryAndAdd1(1,1,n,j+1,i)*2+i-j;
            ans=(ans+s)%1000000007;
            last.put(x,i);
        }
        return (int)ans;
    }

    private void do_(int o,int l,int r,int add){
        sum[o]+=(long)add*(r-l+1);
        todo[o]+=add;
    }

    private long queryAndAdd1(int o,int l,int r,int L,int R){
        if(L<=l&&r<=R){
            long res=sum[o];
            do_(o,l,r,1);
            return res;
        }

        int m=(l+r)/2;
        int add=todo[o];
        if(add!=0){
            do_(o*2,l,m,add);
            do_(o*2+1,m+1,r,add);
            todo[o]=0;
        }
        long res=0;
        if(L<=m)res+=queryAndAdd1(o*2,l,m,L,R);
        if(R>m)res+=queryAndAdd1(o*2+1,m+1,r,L,R);
        sum[o]=sum[o*2]+sum[o*2+1];
        return res;
    }
}
