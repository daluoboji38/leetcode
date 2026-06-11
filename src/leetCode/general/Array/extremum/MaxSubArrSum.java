package leetCode.general.Array.extremum;

// 最大子数组总值 I
public class MaxSubArrSum {
    public long maxTotalValue(int[] nums, int k) {
        int mn=Integer.MAX_VALUE,mx=0;
        for(int x:nums){
            mn=Math.min(mn,x);
            mx=Math.max(mx,x);
        }
        return (long)(mx-mn)*k;
    }
}
