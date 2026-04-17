package leetCode.general.matrix;

// 元素和小于等于 k 的子矩阵的数目

public class matrixElementSum {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid[0].length;
        int[] colSum  = new int[n];
        int ans = 0;
        for (int[] row : grid) {
            int s = 0;
            for(int j=0;j<n;j++){
                colSum[j] += row[j];
                s += colSum[j];
                if(s>k){
                    break;
                }
                ans++;
            }
        }
        return ans;
    }
}
