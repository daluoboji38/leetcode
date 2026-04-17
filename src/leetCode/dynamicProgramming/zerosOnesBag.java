package leetCode.dynamicProgramming;
// 一和零
//  two bag issue using 3-dimensional array
// dp[i][j][k] means the maximum number of strings based on first i strings, with j zeros and k ones
public class zerosOnesBag {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (zerosOnes[0] <= j && zerosOnes[1] <= k) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zerosOnes[0]][k - zerosOnes[1]] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int[] getZerosOnes(String str){
        int[] zerosOnes = new int[2];
        for(char c : str.toCharArray()){
            zerosOnes[c-'0']++;
        }
        return zerosOnes;
    }
}
