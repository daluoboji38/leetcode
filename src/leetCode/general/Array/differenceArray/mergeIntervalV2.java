package leetCode.general.Array.differenceArray;

import java.util.ArrayList;
import java.util.List;

public class mergeIntervalV2 {
    public int[][] merge(int[][] intervals) {
        int mx=0;
        for(int[] p : intervals){
            mx = Math.max(mx, p[1]);
        }

        int[] diff=new int[mx*2+2];
        for(int[] p : intervals){
            diff[p[0]*2]++;
            diff[p[1]*2+1]--;
        }

        List<int[]> ans=new ArrayList<>();
        int sumD=0;
        int start=-1;
        for(int i=0;i<diff.length;i++){
            sumD+=diff[i];
            if(sumD>0){
                if(start<0){
                    start=i;
                }
            }else if(start>=0){
                ans.add(new int[]{start/2, i/2});
                start=-1;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
