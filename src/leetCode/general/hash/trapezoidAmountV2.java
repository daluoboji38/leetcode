package leetCode.general.hash;

import java.util.HashMap;
import java.util.Map;

// 统计梯形的数目 I
public class trapezoidAmountV2 {
    private static final int MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> cnt = new HashMap<>(points.length,1);
        // preallocate memory reduce memory consumption but increase time spent
        for(int[] p : points){
            cnt.merge(p[1], 1, Integer::sum);
        }
        long ans = 0,s=0;
        for(int c : cnt.values()){
            long k = (long)c*(c-1)/2;
            ans+=s*k;
            s+=k;
        }
        return (int)(ans%MOD);
    }
}
