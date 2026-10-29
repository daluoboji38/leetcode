package leetCode.dfs.TDArr;

// 总价值可以被 K 整除的岛屿数目
public class islandDivByK {
    int cur;
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    cur=0;
                    dfs(grid,i,j,k);
                    ans+=(cur%k==0?1:0);
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int x,int y,int k){
        if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1){
            return;
        }
        if(grid[x][y]==0) return;
        cur+=grid[x][y]%k;
        grid[x][y]=0;
        dfs(grid,x-1,y,k);dfs(grid,x+1,y,k);dfs(grid,x,y-1,k);dfs(grid,x,y+1,k);
    }
}
