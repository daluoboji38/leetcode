package leetCode.binarySearch;

public class pythagoreanTheoremV2 {
    public int countTriples(int n) {
        int ans = 0;
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < a && a * a + b * b <= n * n; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c * c == c2) {
                    ans++;
                }
            }
        }
        return ans * 2; // (a,b,c) 和 (b,a,c) 各算一次
    }
}

