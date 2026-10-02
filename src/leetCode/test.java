package leetCode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    private static final int MOD = 1_000_000_007;

    public int uniqueXorTriplets(int[] nums) {
        if (nums.length == 0) return 0;

        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int len = 1 << (32 - Integer.numberOfLeadingZeros(mx | 1)); // 至少 1
        if (len > 1 << 20) {
            // 太大会 MLE，实际比赛中需特殊处理
            return -1; // 或改用其他方法
        }

        long[] cnt = new long[len];
        for (int x : nums) {
            if (x < len) cnt[x]++;
        }

        long[] res = fwtXOR3(cnt);

        int ans = 0;
        for (long v : res) {
            if (v > 0) ans++;
        }
        return ans;
    }

    private long[] fwtXOR3(long[] a) {
        int n = a.length;

        // Forward FWT
        fwtXOR(a, 0);

        // Pointwise cube + mod
        for (int i = 0; i < n; i++) {
            long x = a[i] % MOD;
            if (x < 0) x += MOD;
            a[i] = x * x % MOD * x % MOD;
        }

        // Inverse FWT
        fwtXOR(a, 1);

        // 修正负数 + 取模
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) a[i] += MOD;
            a[i] %= MOD;
        }
        return a;
    }

    private void fwtXOR(long[] a, int rsh) {
        int n = a.length;
        for (int l = 2, k = 1; l <= n; l <<= 1, k <<= 1) {
            for (int i = 0; i < n; i += l) {
                for (int j = 0; j < k; j++) {
                    long x = a[i + j];
                    long y = a[i + j + k];
                    a[i + j] = (x + y) >> rsh;
                    a[i + j + k] = (x - y) >> rsh;
                }
            }
        }
    }
}
