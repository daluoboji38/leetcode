package leetCode.general.Array.extreme;

//最小操作次数使数组元素相等
public class minOperationToIdentical {
    int MOD = 1_000_000_007;
    public int minMoves(int[] nums) {
        int n = nums.length;
        long min = Integer.MAX_VALUE;
        long sum=0;
        for(int num:nums){
            sum=sum+num;
            min = Math.min(min,num);
        }
        return (int)(sum-min*n)%MOD;
    }
}
