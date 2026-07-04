package leetCode.bfs.Dijkstra;

import java.util.Arrays;
// 网络延迟时间
public class networkDelayDenseG {
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF=Integer.MAX_VALUE/2;
        int[][] g=new int[n][n];// adjacency matrix
        for(int[] row:g){
            Arrays.fill(row,INF);
        }
        for(int[] t:times){
            g[t[0]-1][t[1]-1]=t[2];
        }
        int maxDis=0;
        int[] dis=new int[n];
        Arrays.fill(dis,INF);
        dis[k-1]=0;
        boolean[] done=new boolean[n];
        while(true){
            int x=-1;
            for(int i=0;i<n;i++){
                if(!done[i]&&(x==-1||dis[i]<dis[x]))x=i;
            }
            if(x==-1) return maxDis;
            if(dis[x]==INF)return -1;
            maxDis=dis[x];
            done[x]=true;
            for(int i=0;i<n;i++){
                dis[i]=Math.min(dis[i],dis[x]+g[x][i]);
            }
        }
    }
}
