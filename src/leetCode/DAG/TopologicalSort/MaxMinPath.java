package leetCode.DAG.TopologicalSort;

import java.util.*;

// 恢复网络路径
// Directed Graph
public class MaxMinPath {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n=online.length;
        List<int[]>[] g=new ArrayList[n];
        Arrays.setAll(g, _->new ArrayList<>());
        int[] deg=new int[n];
        int maxWt=-1;
        for (int[] e : edges) {
            int u=e[0], v=e[1], w=e[2];
            if (online[u] && online[v]) {
                g[u].add(new int[]{v, w});
                deg[v]++;
                if(u==0)maxWt = Math.max(maxWt, w);
            }
        }

        // clear path that can't reach to 0
        Queue<Integer> q=new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            if (deg[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] e : g[u]) {
                int v = e[0];
                if (--deg[v] == 0 && v != 0) q.offer(v);
            }
        }

        long f[] = new long[n];
        int left=-1,right=maxWt+1;
        while (left+1<right){
            int mid=left+(right-left)/2;
            if(check(mid,g,deg.clone(),f,k)) left=mid;
            else right=mid;
        }
        return left;
    }

    private boolean check(int lower,List<int[]>[] g,int[] deg,long f[],long k){
        Arrays.fill(f, Long.MAX_VALUE/2);
        f[0] = 0;
        Queue<Integer> q=new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            if(u==g.length-1){return f[u]<=k;}
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (w>=lower) {
                    f[v]=Math.min(f[v],f[u]+w);
                }
                if(--deg[v]==0) q.offer(v);
            }
        }
        return false;
    }
}
