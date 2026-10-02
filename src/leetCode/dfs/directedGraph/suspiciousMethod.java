package leetCode.dfs.directedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 移除可疑的方法
public class suspiciousMethod {
    public List<Integer> remainingMethods(int n,int k,int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : invocations) {
            g[e[0]].add(e[1]);
        }

        // mark all suspicious methods
        boolean[] isSuspicious = new boolean[n];
        dfs(k, g, isSuspicious);

        // check suspicious methods
        for(int[] e : invocations){
            if (!isSuspicious[e[0]] && isSuspicious[e[1]]) {
                List<Integer> ans=new ArrayList<>(n);
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isSuspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }


    private void dfs(int x,List<Integer>[] g,boolean[] isSuspicious){
        isSuspicious[x] = true;
        for (int y : g[x]) {
            if (!isSuspicious[y]) {
                dfs(y, g, isSuspicious);
            }
        }
    }
}
