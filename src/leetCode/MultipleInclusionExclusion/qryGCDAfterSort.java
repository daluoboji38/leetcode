package leetCode.MultipleInclusionExclusion;

// 查询排序后的最大公约数
public class qryGCDAfterSort {
    public int[] gcdValues(int[] nums, long[] queries) {
        int mx=0;
        for(int x:nums){
            mx=Math.max(mx,x);
        }
        int[] cntX=new int[mx+1];
        for(int x:nums){
            cntX[x]++;
        }

        long[] cntGcd=new long[mx+1];
        for(int i=mx;i>0;i--){
            int c=0;
            for(int j=i;j<=mx;j+=i){
                c+=cntX[j];
                cntGcd[i]-=cntGcd[j];
            }
            cntGcd[i]+=(long)c*(c-1)/2;
        }

        for(int i=2;i<=mx;i++){
            cntGcd[i]+=cntGcd[i-1];
        }

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=upperBound(cntGcd,queries[i]);
        }
        return ans;
    }

    private int upperBound(long[] nums, long target) {
        int left = -1, right = nums.length;
        while (left+1 < right) {
            int mid = (left + right)>>>1;
            if (nums[mid]  > target) {
                right = mid ;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
