package leetCode.general.Array.sort;

import java.util.Arrays;

// 最早完成陆地和水上游乐设施的时间 I
public class amuseParkPlan {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landFirst=solve(landStartTime,landDuration,waterStartTime,waterDuration);
        int waterFirst=solve(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(landFirst,waterFirst);
    }

    private int solve(int[] fst,int[] fd,int[] sst,int[] sd) {
        int minFinish=Integer.MAX_VALUE;
        for(int i=0;i<fst.length;i++){
            minFinish=Math.min(minFinish,fst[i]+fd[i]);
        }

        int res=Integer.MAX_VALUE;
        for(int i=0;i<sst.length;i++){
            res=Math.min(res,Math.max(minFinish,sst[i])+sd[i]);
        }
        return res;
    }
}


