package leetCode.dfs.UndirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 统计完全连通分量的数量
public class CliqueComponentCnt {
    private int v;
    private int e;

    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        boolean[] vis = new boolean[n];
        int ans=0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                v=0;
                e=0;
                dfs(i, g, vis);
                if(e==v*(v-1)) ans++;
            }
        }
        return ans;
    }


    private void dfs(int i, List<Integer>[] g, boolean[] vis) {
        v++;
        e+=g[i].size();
        vis[i] = true;
        for (int j : g[i]) {
            if (!vis[j]) {
                dfs(j, g, vis);
            }
        }
    }
}
