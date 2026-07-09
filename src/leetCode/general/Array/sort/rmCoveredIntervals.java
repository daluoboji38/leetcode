package leetCode.general.Array.sort;

import java.util.Arrays;

// 删除被覆盖区间
public class rmCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);

        int ans = 0;
        int maxRight=0;
        for(int[] p:intervals){
            if(p[1]>maxRight){
                maxRight=p[1];
                ans++;
            }
        }
        return ans;
    }
}
