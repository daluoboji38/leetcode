package leetCode.Contribute.bidirectionalLinkedList;

// 将子数组重新排序得到同一个二叉搜索树的方案数
public class ReArrangeBTreeCut {
    private static final int MOD = 1_000_000_007;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        int[] pre =new int[n+2];
        int[] next = new int[n+2];
        int[] size = new int[n+2];
        for(int i=0;i<n+2;i++){
            pre[i]=i-1;
            next[i]=i+1;
        }
        long fac=1; // Numerator
        long prod=1; // denominator

        for(int i=n-1;i>=0;i--){
            fac=fac*(i+1)%MOD;
            int x=nums[i];
            size[x]=1;

            int left=pre[x];
            if(size[left]>0){
                size[x]+=size[left];
                int pl=pre[left];
                pre[x]=pl;
                next[pl]=x;
            }

            int right=next[x];
            if(size[right]>0){
                size[x]+=size[right];
                int pl=next[right];
                pre[pl]=x;
                next[x]=pl;
            }
            prod=prod*size[x]%MOD;
        }
        return (int)((fac*pow(prod,MOD-2)-1+MOD)%MOD);
    }

    private long pow(long x,long n){
        long res=1;
        for(;n>0;n/=2){
            if(n%2>0){res=res*x%MOD;}
            x=x*x%MOD;
        }
        return res;
    }

}
