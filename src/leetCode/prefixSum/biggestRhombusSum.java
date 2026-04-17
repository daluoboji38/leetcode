package leetCode.prefixSum;
// 矩阵中最大的三个菱形和

import java.util.Arrays;

public class biggestRhombusSum {
    private int x,y,z; // Largest, second largest, third largest

    public int[] getBiggestThree(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] diagSum = new int[m+1][n+1]; // ↘ prefix sum.
        int[][] antiSum = new int[m+1][n+1]; // ↙ prefix sum.
        for(int i=0; i<m; i++){
            for(int j= 0; j<n; j++){
                int v = grid[i][j];
                diagSum[i+1][j+1] = diagSum[i][j] + v;  // fisrt one stored at [1,1]
                antiSum[i+1][j] = antiSum[i][j+1] + v; // first one stored at [1,0]
            }
        }

        // central of rhombus: (i,j)
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                update(grid[i][j]);
                // k is the distance from central to the vertex of rhombus.
                // i-k>=0 and i+k<=m-1, same to j.
                int mx = Math.min(Math.min(i, m-1-i), Math.min(j, n-1-j));
                for(int k=1; k<=mx; k++){
                    int a = queryDiagonal(diagSum, i-k, j, k); // right up rim, stariting from (i-k,j)
                    int b = queryDiagonal(diagSum, i, j-k, k); // left down rim, starting from (i,j-k)
                    int c = queryAntiDiagonal(antiSum, i-k+1, j-1, k-1); // left up rim starting from (i-k+1,j-1)
                    int d = queryAntiDiagonal(antiSum, i, j+k, k+1);   // right down rim starting from (i,j+k)
                    update(a+b+c+d);
                }
            }
        }

        int[] ans=new int[]{x,y,z};
        int len=3;
        while(ans[len-1]==0){
            len--;
        }
        return Arrays.copyOf(ans, len);
    }

    // subsequent k sum starting from grid[x][y] towards ↘ direction.
    private int queryDiagonal(int[][] diagSum, int x, int y, int k){
        return diagSum[x+k][y+k] - diagSum[x][y];
    }

    // subsequent k sum starting from grid[x][y] towards ↙ direction.
    private int queryAntiDiagonal(int[][] antiDiagSum, int x, int y, int k){
        return antiDiagSum[x+k][y+1-k] - antiDiagSum[x][y+1];
    }

    private void update(int v){
        if (v > x) {
            z = y;
            y = x;
            x = v;
        }else if (v < x && v > y) {
            z = y;
            y = v;
        }else if (v < y && v > z) {
            z = v;
        }
    }
}
