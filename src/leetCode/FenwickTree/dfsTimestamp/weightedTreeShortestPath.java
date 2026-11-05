package leetCode.FenwickTree.dfsTimestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//带权树中的最短路径
class FenwickTree {
    private final int[] tree;

    public FenwickTree(int n) {
        tree = new int[n + 1];
    }

    public void update(int i, int val) {
        for (; i < tree.length; i += i & -i) {
            tree[i] += val;
        }
    }

    public int pre(int i) {
        int res = 0;
        for (; i > 0; i &= i - 1) {
            res += tree[i];
        }
        return res;
    }
}


public class weightedTreeShortestPath {
    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        List<Integer>[] g=new ArrayList[n+1];
        Arrays.setAll(g, i->new ArrayList<>());
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int[] in=new int[n+1];
        int[] out=new int[n+1];
        dfs(1,0,g,in,out);

        int[] weight=new int[n+1];
        FenwickTree diff=new FenwickTree(n);

        for(int[] e:edges){
            update(e[0],e[1],e[2],in,out,weight,diff);
        }

        List<Integer> ans=new ArrayList<>();
        for(int[] q:queries){
            if(q[0]==1){
                update(q[1],q[2],q[3],in,out,weight,diff);
            }else{
                ans.add(diff.pre(in[q[1]]));
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }

    private int clock=0;

    private void dfs(int x,int fa,List<Integer>[] g,int[] in,int[] out){
        in[x]=++clock;
        for(int y:g[x]){
            if(y!=fa){dfs(y,x,g,in,out);}
        }
        out[x]=clock;
    }

    private void update(int x,int y,int w,int[] in,int[] out,int[] weight,FenwickTree diff){
        if(in[x]>in[y])y=x; // make sure y is child
        int d=w-weight[y];
        weight[y]=w;
        diff.update(in[y],d);
        diff.update(out[y]+1,-d);
    }
}
