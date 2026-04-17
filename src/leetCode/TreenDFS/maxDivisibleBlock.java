package leetCode.TreenDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 可以被k整除连通块的最大数量
public class maxDivisibleBlock {
    private int ans = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k){
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g,_->new ArrayList<>());
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0,-1,g,values,k);
        return ans;
    }
// depth first search
    private long dfs(int x,int fa,List<Integer>[] g,int[] values,int k){
        long sum=values[x];
        for(int y:g[x]){
            if(y!=fa){
                sum+=dfs(y,x,g,values,k);
            }
    }
        ans+=sum%k==0?1:0;
        return sum;
    }
}
