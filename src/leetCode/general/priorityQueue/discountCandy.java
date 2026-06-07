package leetCode.general.priorityQueue;

import java.util.Arrays;

// 打折购买糖果的最小开销
public class discountCandy {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int ans=0;
        for (int i = n-1; i >=0; i--) {
            if((n-i)%3==0)continue;
            ans+=cost[i];
        }
        return ans;
    }
}
