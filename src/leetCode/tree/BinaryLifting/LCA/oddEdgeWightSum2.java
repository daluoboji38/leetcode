package leetCode.tree.BinaryLifting.LCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class oddEdgeWightSum2 {
    private static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        LcaBinaryLifting g = new LcaBinaryLifting(edges);

        int[] pow2=new int[edges.length+1];
        pow2[0]=1;
        for(int i=1;i<pow2.length;i++)
            pow2[i]=(pow2[i-1]*2)%MOD;

        int[] ans=new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int x=queries[i][0]-1;
            int y=queries[i][1]-1;
            if(x!=y){
                ans[i]=pow2[g.getDis(x,y)-1];
            }
        }
        return ans;
    }
}

class LcaBinaryLifting{
    private final int[] depth;
    private final int[][] pa;

    public LcaBinaryLifting(int[][] edges){
        int n=edges.length+1;
        int m=32-Integer.numberOfLeadingZeros(n);
        List<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, e->new ArrayList<>());
        for (int[] e : edges) {
            int x=e[0]-1;
            int y=e[1]-1;
            g[x].add(y);
            g[y].add(x);
        }

        depth=new int[n];
        pa=new int[n][m];
        dfs(g,0,-1);

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                int p=pa[j][i];
                pa[j][i+1]=p<0?-1:pa[p][i];
            }
        }
    }

    private void dfs(List<Integer>[] g, int x, int fa) {
        pa[x][0]=fa;
        for(int y:g[x]){
            if(y!=fa){
                depth[y]=depth[x]+1;
                dfs(g,y,x);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(;k>0;k&=k-1){
            node=pa[node][Integer.numberOfTrailingZeros(k)];
        }
        return node;
    }

    public int getLCA(int x,int y){
        if(depth[x]>depth[y]){
            int tmp=y;
            y=x;
            x=tmp;
        }
        y=getKthAncestor(y,depth[y]-depth[x]);
        if(y==x) return x;
        for(int i=pa[x].length-1;i>=0;i--){
            int px=pa[x][i];
            int py=pa[y][i];
            if(px!=py){
                x=px;
                y=py;
            }
        }
        return pa[x][0];
    }

    public int getDis(int x,int y){
        return depth[x]+depth[y]-2*depth[getLCA(x,y)];
    }

}
