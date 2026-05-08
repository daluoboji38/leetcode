package leetCode.iteration;

import java.util.Arrays;

// 网格中得分最大的路径
public class optimalPath {
    public int maxPathScore(int[][] grid, int k) {
        if(minPathSum(grid)>k){
            return -1;
        }
        int m=grid.length;
        int n=grid[0].length;
        // k represents the exact consumption from the start point to the end point.
        k=Math.min(k,m+n-2);
        int[][] f=new int[n+1][k+2];
        for(int[] row:f){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        f[1][1]=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=grid[i][j];
                for(int t=Math.min(k,i+j);t>=0;t--){
                    int newK=x>0?t-1:t;
                    f[j+1][t+1]=Math.max(f[j+1][newK+1], f[j][newK+1])+x;
                }
            }
        }

        int ans=0;
        for(int x:f[n]){
            ans=Math.max(ans, x);
        }
        return ans;
    }

    private int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int[] f=new int[n+1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[1] = 0;
        for(int[] row: grid){
            for(int j=0;j<n;j++){
                f[j+1] = Math.min(f[j], f[j+1])+Math.min(row[j],1);
            }
        }
        return f[n];
    }

}
