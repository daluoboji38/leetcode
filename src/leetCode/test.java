package leetCode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int k = r - l + 1;

        int[] f0 = new int[k]; // 后两个数递增
        int[] f1 = new int[k]; // 后两个数递减
        Arrays.fill(f0, 1);
        Arrays.fill(f1, 1);
        long[] s0 = new long[k + 1];
        long[] s1 = new long[k + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                s0[j + 1] = s0[j] + f0[j];
                s1[j + 1] = s1[j] + f1[j];
            }
            for (int j = 0; j < k; j++) {
                f0[j] = (int) (s1[j] % MOD);
                f1[j] = (int) ((s0[k] - s0[j + 1]) % MOD);
            }
        }

        long ans = 0;
        for (int j = 0; j < k; j++) {
            ans += f0[j] + f1[j];
        }
        return (int) (ans % MOD);
    }
}

