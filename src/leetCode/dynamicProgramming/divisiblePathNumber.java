package leetCode.dynamicProgramming;
// 矩阵中和能被k整除的路径
public class divisiblePathNumber {
    public int numberOfPaths(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m+1][n+1][k]; // dp[i][j][p] represents the number of paths from (0,0) to (i,j) with remainder p
        int val = 0;
        dp[1][1][grid[0][0]%k]++;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                for(int p=0; p<k; p++){
                    if(dp[i-1][j][p] > 0){
                        val = (p+grid[i-1][j-1])%k;
                        dp[i][j][val] += dp[i-1][j][p];
                        dp[i][j][val] %= 1000000007;
                    }
                    if(dp[i][j-1][p] > 0){
                        val = (p+grid[i-1][j-1])%k;
                        dp[i][j][val] += dp[i][j-1][p];
                        dp[i][j][val] %= 1000000007;
                    }
                }
                }
            }
        return dp[m][n][0];
    }
}
