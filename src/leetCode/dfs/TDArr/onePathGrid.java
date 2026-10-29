package leetCode.dfs.TDArr;

//构造恰好一条路径的网格
public class onePathGrid {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        ans[0]= ".".repeat(n);
        String row="#".repeat(n-1)+".";
        for (int i = 1; i < m; i++) {
            ans[i]=row;
        }
        return ans;
    }
}
