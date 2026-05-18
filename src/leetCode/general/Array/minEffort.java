package leetCode.general.Array;

import java.util.Arrays;

// 完成所有任务的最少初始能量
public class minEffort {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> b[1] - b[0] - (a[1] - a[0]));
        int ans=0,s=0;
        for(int[] t:tasks){
            int actual=t[0];
            int required=t[1];
            ans=Math.max(ans,s+required);
            s+=actual;
        }
        return ans;
    }
}
