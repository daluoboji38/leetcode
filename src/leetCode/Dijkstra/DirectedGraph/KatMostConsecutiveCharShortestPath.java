package leetCode.Dijkstra.DirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// 最多 K 个连续相同字符的最短路径
public class KatMostConsecutiveCharShortestPath {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        char[] s=labels.toCharArray();
        List<int[]>[] g=new ArrayList[n];
        Arrays.setAll(g, _->new ArrayList<>());
        for(int[] e:edges){
            g[e[0]].add(new int[]{e[1],e[2]});
        }
        int[][] dis=new int[n][k+1];
        for(int[] row:dis){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        // int[]{shortest length,node num,last consecutive identical char num}
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,1});

        while(!pq.isEmpty()){
            int[] top=pq.poll();
            int d=top[0],x=top[1],cnt=top[2];
            if(x==n-1)return d;
            if(d>dis[x][cnt]){continue;}
            for(int[] e:g[x]){
                int y=e[0];
                int newCnt=s[y]==s[x]?cnt+1:1;
                int newDis=d+e[1];
                if(newCnt<=k && newDis<dis[y][newCnt]){
                    dis[y][newCnt]=newDis;
                    pq.add(new int[]{newDis,y,newCnt});
                }
            }
        }
        return -1;
    }
}
