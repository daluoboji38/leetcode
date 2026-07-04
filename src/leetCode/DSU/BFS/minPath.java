package leetCode.DSU.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 两个城市间路径的最小分数
public class minPath {
    private int ans=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<int[]>[] g=new ArrayList[n+1];
        Arrays.setAll(g, _->new ArrayList<>());
        for(int[] e:roads){
            g[e[0]].add(new int[]{e[1],e[2]});
            g[e[1]].add(new int[]{e[0],e[2]});
        }

        boolean[] vis=new boolean[n+1];
        dfs(1,g,vis);
        return ans;
    }

    private void dfs(int u,List<int[]>[] g,boolean[] vis){
        vis[u]=true;
        for(int[] e:g[u]){
            ans=Math.min(ans,e[1]);
            if(!vis[e[0]]){
                dfs(e[0],g,vis);
            }
        }
    }
}
