package leetCode.dfs.TDArr;

// 网格图中最小异或路径
// XOR same is 0, different is 1
public class minXORPath {
    private int ans=Integer.MAX_VALUE;
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int orAll=0;
        for(int[] row:grid){
            for(int x:row){
                orAll|=x;
            }
        }
        boolean[][][] vis=new boolean[m][n][orAll+1];
        dfs(m-1,n-1,0,grid,vis);
        return ans;
    }

    private void dfs(int i,int j,int xor,int[][] grid,boolean[][][] vis){
        if(ans==0 || i<0 || j<0 || vis[i][j][xor]){
            return;
        }
        vis[i][j][xor]=true;
        xor^=grid[i][j];
        if(i==0&&j==0){
            ans=Math.min(ans,xor);
            return;
        }
        dfs(i-1,j,xor,grid,vis);
        dfs(i,j-1,xor,grid,vis);
    }
}
