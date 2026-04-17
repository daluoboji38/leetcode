package leetCode.prefixSum;
// 长度可被K整除的子数组的最大元素和
public class maxPrefixSum {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int d = n / k;
        long res = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            for(int j=1;j<=d&&i+j*k<=n;j++){
                for(int t=j-1;t>=0;t--){
                    long tmp = sum(nums,i+t*k,i+j*k);
                    res = Math.max(res,tmp);
                }
            }
        }
        return res;
    }

    public long sum(int[] nums, int start, int end){
        long sum = 0;
        for(int i=start;i<end;i++){
            sum += nums[i];
        }
        return sum;
    }
}
