package leetCode.greedy.List;

import java.util.List;

// 对数组执行操作使平方和最大
public class maxSquareSumAfterBinOp {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007;
        int[] cnt=new int[30];
        for(int x:nums) {
            for(int i=0;i<30;i++) {
                cnt[i]+=(x>>i)&1;
            }
        }
        long ans=0;
        while(k-- > 0) {
            int x=0;
            for(int i=0;i<30;i++) {
                if(cnt[i]>0) {
                    cnt[i]--;
                    x|=(1<<i);
                }
            }
            ans=(ans+(long)x*x)%MOD;
        }
        return (int)ans;
    }
}
