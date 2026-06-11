package leetCode.tree.edge;

// 给边赋权值的方案数 I

// From k distinct elements, the number of ways to choose an odd number of elements is 2^(k−1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class oddEdgeWightSum {
    private static final int MOD = 1_000_000_007;
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n+1];
        Arrays.setAll(g,i->new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        int k=dfs(1,0,g);
        return (int)pow(2,k-1);
    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int d=0;
        for(int y:g[x]){
            if(y!=fa){
                d=Math.max(d,dfs(y,x,g)+1);
            }
        }
        return d;
    }

    private long pow(long x,int n){
        long res = 1;
        for(; n > 0; n /= 2){
            if(n % 2 == 1) res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }
}
