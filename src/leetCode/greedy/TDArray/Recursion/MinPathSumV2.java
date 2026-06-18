package leetCode.greedy.TDArray.Recursion;

public class MinPathSumV2 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp(grid,m-1,n-1,m,n);
        return grid[0][0];
    }

    public void dp(int[][] grid,int x,int y, int m, int n) {
        for(int i=x;i>=0;i--){
            int down=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;
            if(i+1<m) down = grid[i+1][y];
            if(y+1<n) right = grid[i][y+1];
            if(down!=Integer.MAX_VALUE || right!=Integer.MAX_VALUE){
                grid[i][y]+=Math.min(down,right);
            }
        }
        for(int j=y-1;j>=0;j--){
            int down=Integer.MAX_VALUE;
            int right=Integer.MAX_VALUE;
            if(x+1<m) down = grid[x+1][j];
            if(j+1<n) right = grid[x][j+1];
            if(down!=Integer.MAX_VALUE || right!=Integer.MAX_VALUE){
                grid[x][j]+=Math.min(down,right);
            }
        }

        if(x==0 || y==0) return;

        dp(grid,x-1,y-1,m,n);
    }
}
