package leetCode.dfs.TDArr;

// 统计封闭岛屿的数目
public class ClosedIsland {
    private boolean closed;
    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        if(m<3 || n<3) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    closed=true;
                    dfs(grid,i,j);
                    if(closed) ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int x,int y){
        if(x==0 || y==0 || x==grid.length-1 || y==grid[0].length-1){
            if(grid[x][y]==0) closed=false;
            return;
        }
        if(grid[x][y]!=0) return;
        grid[x][y]=1;
        dfs(grid,x-1,y);dfs(grid,x+1,y);dfs(grid,x,y-1);dfs(grid,x,y+1);
    }
}
