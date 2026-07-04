package leetCode.greedy.Array.extremum;

import java.util.List;

// 最大得分的路径数目
public class MaxScorePath {
    private static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size(),n = board.getFirst().length();
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board.get(i).charAt(j);
                if(c<48 || c>57){
                    b[i][j] = -1;
                }else {
                    b[i][j] = c - '0';
                }
            }
        }
        int[][] cnt = new int[m][n];
        b[m-1][n-1] = 0;
        b[0][0] = 0;
        cnt[m-1][n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if (b[m-1][i] == -1) break;
            cnt[m-1][i] = 1;
            b[m-1][i]+= b[m-1][i+1];
        }
        for (int i = m - 2; i >= 0; i--) {
            if (b[i][n-1] == -1) break;
            cnt[i][n-1] = 1;
            b[i][n-1]+= b[i+1][n-1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (b[i][j] == -1) continue;
                if(b[i+1][j] == -1 && b[i][j+1] == -1&& b[i+1][j+1] != -1){
                    cnt[i][j] = cnt[i+1][j+1];
                    b[i][j] += b[i+1][j+1];
                }else if(b[i+1][j] != -1 && b[i][j+1] != -1){
                    if(b[i+1][j] > b[i][j+1]){
                        cnt[i][j] = cnt[i+1][j];
                        b[i][j] += b[i+1][j];
                    }else if(b[i+1][j] < b[i][j+1]){
                        cnt[i][j] = cnt[i][j+1];
                        b[i][j] += b[i][j+1];
                    }else{
                        cnt[i][j] = (cnt[i+1][j] + cnt[i][j+1]) % MOD;
                        b[i][j] += b[i][j+1];
                    }
                }else if(b[i+1][j] !=-1){
                    cnt[i][j] = cnt[i+1][j];
                    b[i][j] += b[i+1][j];
                }else{
                    cnt[i][j] = cnt[i][j+1];
                    b[i][j] += b[i][j+1];
                }
            }
        }
        return cnt[0][0] == 0 ? new int[]{0,0} : new int[]{b[0][0], cnt[0][0]};
    }
}
