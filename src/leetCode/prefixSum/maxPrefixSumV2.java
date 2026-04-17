package leetCode.prefixSum;
// 长度可被K整除的子数组的最大元素和

import java.util.Arrays;

public class maxPrefixSumV2 {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minS = new long[k]; // mantain the minimum sum of each group of indices
        Arrays.fill(minS, 0,k-1,Long.MAX_VALUE/2);

        long ans = Long.MIN_VALUE;
        long sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            int i=j%k;
            ans = Math.max(ans, sum - minS[i]);
            minS[i] = Math.min(minS[i], sum);
        }
        return ans;
    }
}
