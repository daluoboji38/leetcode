package leetCode.dfs.TDArr;

// 检查是否有合法括号字符串路径
public class validParenthesesPath {
    int m;
    int n;
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if((m+n)%2==0 || grid[0][0]==')' || grid[m-1][n-1]=='(') return false;
        return dfs(0,0,0,grid,new boolean[m][n][(m+n+1)/2]);

    }

    private boolean dfs(int x,int y,int c,char[][] grid,boolean[][][] vis){
        if(c>m-x+n-y-1)return false;
        if(x==m-1&&y==n-1)return c==1;
        if(vis[x][y][c])return false;
        vis[x][y][c]=true;
        c+=grid[x][y]=='('?1:-1;
        if(c<0)return false;
        return x<m-1 && dfs(x+1,y,c,grid,vis)||
                y<n-1 && dfs(x,y+1,c,grid,vis);
    }
}
