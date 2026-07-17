package leetCode.ST;

import java.util.PriorityQueue;

// 最大子数组总值 II
public class MaxSubArrSum2 {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        ST st = new ST(nums);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{st.query(0,n), 0,n});

        long ans=0;
        while(k-->0 && pq.peek()[0]>0){
            int[] top = pq.poll();
            int d=top[0], l=top[1], r=top[2];
            ans+=d;
            pq.add(new int[]{st.query(l,r-1),l,r-1});
            if(r==n && l+1<n){
                pq.add(new int[]{st.query(l+1,n),l+1,n});
            }
        }
        return ans;
    }


}

class ST{
    private final int[][] stMin;
    private final int[][] stMax;

    public ST(int[] a){
        int n=a.length;
        int w=32-Integer.numberOfLeadingZeros(n);
        stMin=new int[w][n];
        stMax=new int[w][n];

        for(int i=0;i<n;i++){
            stMin[0][i]=a[i];
            stMax[0][i]=a[i];
        }

        for(int i=1;i<w;i++){
            for(int j=0;j+(1<<i)<=n;j++){
                stMin[i][j]=Math.min(stMin[i-1][j],stMin[i-1][j+(1<<i-1)]);
                stMax[i][j]=Math.max(stMax[i-1][j],stMax[i-1][j+(1<<i-1)]);
            }
        }
    }

    public int query(int l,int r){
        int k=31-Integer.numberOfLeadingZeros(r-l);
        int mn=Math.min(stMin[k][l],stMin[k][r-(1<<k)]);
        int mx=Math.max(stMax[k][l],stMax[k][r-(1<<k)]);
        return mx-mn;
    }
}