package leetCode.general.Array;

// 区间乘法查询后的异或 I

import java.util.Arrays;

public class XORAfterRangeMultiQry {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long[] longNums = Arrays.stream(nums).mapToLong(l -> l).toArray();
        for (int i = 0; i < queries.length; i++) {
            int k=queries[i][3];
            for(int j=queries[i][0];j<=queries[i][1];j+=queries[i][2]){
                longNums[j]=(longNums[j] * k) % 1000000007;
            }
        }
        long ans=0;
        for(long num:longNums){
            ans ^= num;
        }
        return (int)ans;
    }
}
