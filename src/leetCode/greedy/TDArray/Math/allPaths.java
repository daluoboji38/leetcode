package leetCode.greedy.TDArray.Math;

// 不同路径
public class allPaths {
    public int uniquePaths(int m, int n) {
        return (int) comb(m + n - 2, n - 1);
    }

    private long comb(int n, int k) {
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n + 1 - i) / i;
        }
        return res;
    }
}
