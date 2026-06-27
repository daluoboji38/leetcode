package leetCode.general.Array.extremum;

import java.util.Arrays;

// 减小和重新排列数组后的最大元素
public class ArrMaxUnderRule {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int[] cnt=new int[n+1];
        for(int x:arr)cnt[Math.min(x,n)]++;
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.min(ans+cnt[i],i);
        }
        return ans;
    }
}
