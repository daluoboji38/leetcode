package leetCode.prefixSum.Array;

// 最大子数组和
public class maxSubArr {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int min = 0,ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
            }

        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i-1]);
            ans=Math.max(ans, nums[i]-min);
        }
        return ans;
    }
}
