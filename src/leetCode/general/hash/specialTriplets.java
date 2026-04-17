package leetCode.general.hash;
// 统计特殊三元组

import java.util.HashMap;
import java.util.Map;

public class specialTriplets {
    public int specialTriplets(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> suf = new HashMap<>();
        for (int x: nums){
            suf.merge(x, 1, Integer::sum);
        }

        long ans=0;
        Map<Integer, Integer> pre = new HashMap<>(); // pre represent [0,j-1], suf represent [j+1,n-1]
        for (int x: nums){
            suf.merge(x, -1, Integer::sum);
            ans+=(long)pre.getOrDefault(2*x,0) * suf.getOrDefault(2*x,0);
            pre.merge(x, 1, Integer::sum);
        }
        return (int)(ans%MOD);
    }
}
