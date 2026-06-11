package leetCode.general.Array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 合并区间
public class mergeIntervalV1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

        List<int[]> ans = new ArrayList<>();
        for(int[] p: intervals){
            int m=ans.size();
            if(m>0 && p[0]<=ans.get(m-1)[1]){
                ans.get(m-1)[1] = Math.max(ans.get(m-1)[1], p[1]);
            }else{
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
