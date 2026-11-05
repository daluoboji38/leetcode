package leetCode.FenwickTree.LCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 查询树上回文路径

class FenwickTree{
    private final int[] tree;
    public FenwickTree(int n){
        tree = new int[n+1];
    }

    public void update(int i, int val){
        for(;i<tree.length;i+=i&-i){
            tree[i]^=val;
        }
    }

    public int pre(int i){
        int res=0;
        for(;i>0;i&=i-1)res^=tree[i];
        return res;
    }
}

class LcaBinaryLifting{
    private final int[] depth;
    private final int[][] pa;
    private int clock=0;

    public final int[] tin;
    public final int[] tout;
    public final int[] pathXorFromRoot;

    LcaBinaryLifting(int[][] edges,char[] s){
        int n=edges.length+1;
        int m=32-Integer.numberOfLeadingZeros(n);
        List<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, i->new ArrayList<>());
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            g[x].add(y);
            g[y].add(x);
        }

        depth=new int[n];
        pa=new int[m][n];
        tin=new int[n];
        tout=new int[n];
        pathXorFromRoot=new int[n];
        pathXorFromRoot[0]=1<<(s[0]-'a');

        dfs(0,-1,g,s);

        for(int i=0;i<m-1;i++){
            for(int x=0;x<n;x++){
                int p=pa[i][x];
                pa[i+1][x]=p<0?-1:pa[i][p];
            }
        }
    }

    private void dfs(int x,int fa,List<Integer>[] g,char[] s){
        pa[0][x]=fa;
        tin[x]=++clock;
        for(int y:g[x]){
            if(y!=fa){
                depth[y]=depth[x]+1;
                pathXorFromRoot[y]=pathXorFromRoot[x]^(1<<(s[y]-'a'));
                dfs(y,x,g,s);
            }
        }
        tout[x]=clock;
    }

    private int getKthAncestor(int node,int k){
        for(;k>0&&node>=0;k&=k-1){
            node=pa[Integer.numberOfTrailingZeros(k)][node];
        }
        return node;
    }

    public int getLCA(int x,int y){
        if(depth[x]>depth[y]){
            int temp=y;
            y=x;
            x=temp;
        }
        y=getKthAncestor(y,depth[y]-depth[x]);
        if(y==x){return x;}
        for(int i=pa.length-1;i>=0;i--){
            int px=pa[i][x],py=pa[i][y];
            if(px!=py){
                x=px;
                y=py;
            }
        }
        return pa[0][x];
    }
}

public class searchPalindromeOnTree {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        char[] t=s.toCharArray();
        LcaBinaryLifting g=new LcaBinaryLifting(edges,t);
        FenwickTree f=new FenwickTree(n);
        List<Boolean> ans=new ArrayList<>();

        for(String q:queries){
            String[] parts=q.split(" ");
            int x=Integer.parseInt(parts[1]);
            if(parts[0].charAt(0)=='u'){
                char c=parts[2].charAt(0);
                int val=(1<<(t[x]-'a'))^(1<<(c-'a'));
                t[x]=c;
                f.update(g.tin[x],val);
                f.update(g.tout[x]+1,val);
            }else{
                int y=Integer.parseInt(parts[2]);
                int lca=g.getLCA(x,y);
                int res=g.pathXorFromRoot[x]^g.pathXorFromRoot[y]^f.pre(g.tin[y])^f.pre(g.tin[x])^(1<<(t[lca]-'a'));
                ans.add((res&(res-1))==0);
            }
        }
        return ans;
    }
}
