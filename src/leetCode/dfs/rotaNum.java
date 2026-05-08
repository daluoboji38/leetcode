package leetCode.dfs;

import java.util.Arrays;

// 旋转数字
public class rotaNum {
    private static int[] DIFFS = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1}; // mark good num

    public int rotatedDigits(int n) {
        char[] s = Integer.toString(n).toCharArray();
        int[][] memo = new int[s.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, true, s, memo);
    }

    // hasDiff: 0 or 1(Some of the previous numbers are good.)
    // isLimit: whether the current number is limited by n
    private int dfs(int i, int hasDiff, boolean isLimit, char[] s, int[][] memo) {
        if (i == s.length) {
            return hasDiff; // count only if DIFFS[d]=1
        }
            if (!isLimit && memo[i][hasDiff] >= 0) {
                return memo[i][hasDiff];
            }
            int res = 0;
            int up = isLimit ? s[i] - '0' : 9;
            for (int d = 0; d <= up; d++) {
                if (DIFFS[d] != -1) {
                    res += dfs(i + 1, hasDiff | DIFFS[d], isLimit && d == up, s, memo);
                }
            }
            if (!isLimit) { // If constrained, the current result requires special processing and calculation; if unconstrained, the current result can be reused repeatedly, hence the use of memoization.
                memo[i][hasDiff] = res;
            }
            return res;
        }
    }


