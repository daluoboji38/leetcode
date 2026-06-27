package leetCode.greedy.Array.extremum;

import java.util.Arrays;

// 找到带限制序列的最大值
public class maxInRestrictedSeq {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        int[] maxVal=new int[n];
        Arrays.fill(maxVal, Integer.MAX_VALUE);
        for (int[] r : restrictions) {
            maxVal[r[0]]=r[1];
        }

        int[] a=new int[n];
        for (int i = 0; i < n-1; i++) {
            a[i+1]=Math.min(a[i]+diff[i], maxVal[i+1]);
        }
        int ans=a[n-1];
        for (int i = n-2; i >= 0; i--) {
            a[i]=Math.min(a[i+1]+diff[i], a[i]);
            ans=Math.max(ans, a[i]);
        }
        return ans;
    }
}
