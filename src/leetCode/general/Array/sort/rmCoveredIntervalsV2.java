package leetCode.general.Array.sort;

import java.util.ArrayList;
import java.util.List;

// 删除被覆盖区间
public class rmCoveredIntervalsV2 {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        for(int[] interval: intervals){
            int a=interval[0],b=interval[1];
            boolean flag=false;
            for(int[] pre:res){
                int c=pre[0],d=pre[1];
                if(a>=c&&d>=b){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                for(int i=0;i<res.size();){
                    int[] pre=res.get(i);
                    int c=pre[0],d=pre[1];
                    if(a<=c&&d<=b){
                        res.remove(i);
                    }else{
                        i++;
                    }
                }
                res.add(new int[]{a,b});
            }
        }
        return res.size();
    }
}
