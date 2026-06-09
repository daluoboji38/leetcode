package leetCode.prefixSum.Array;

public class maxSubArrV2 {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
