package leetCode.graph.directed.LinkedAdjacencyList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 移除可疑的方法

public class suspiciousMethodV2 {
    public List<Integer> remainingMethods(int n,int k,int[][] invocations){
        int m=invocations.length;
        int[] head=new int[n],nxt=new int[m];
        Arrays.fill(head,-1);

        // Chain Forward Star Graph Storage
        // Adjacency list template
        for(int i=0;i<m;i++){
            int u=invocations[i][0];
            nxt[i]=head[u];
            head[u]=i;
        }

        // bfs Traversing the forward graph, mark all suspicious
        int[] q=new int[n];
        boolean[] vis=new boolean[n];
        int s=0,e=-1;
        vis[q[++e]=k]=true;
        while(s<=e){
            int u=q[s++];
            for(int i=head[u];i>-1;i=nxt[i]){
                int v=invocations[i][1];
                if(!vis[v]){vis[q[++e]=v]=true;}
            }
        }

        // Constructing a reverse graph
        Arrays.fill(head,-1);
        for(int i=0;i<m;i++){
            int u=invocations[i][1];
            nxt[i]=head[u];
            head[u]=i;
        }

        // validation
        List<Integer> ans=new ArrayList<>(n);
        for(int v=0;v<n;v++){
            if(!vis[v]){
                ans.add(v);
                continue;
            }
            for(int i=head[v];i>-1;i=nxt[i]){
                int u=invocations[i][0];
                // clean u call suspicious method v
                if(!vis[u]){
                    ans.clear();
                    for(int z=0;z<n;z++){ans.add(z);}
                    return ans;
                }
            }
        }
        return ans;
    }
}
