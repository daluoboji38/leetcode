package leetCode.Dijkstra.TDArr;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

// 穿越网格图的安全路径
public class safePath {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(),n = grid.getFirst().size();
        Integer[][] a=new Integer[m][];
        int[][] dis=new int[m][n];
        for(int i=0;i<m;i++){
            a[i]=grid.get(i).toArray(Integer[]::new);
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[0][0]=a[0][0];
        Deque<int[]> q=new ArrayDeque<>();
        q.addFirst(new int[]{0,0});
        while(true){
            int[] p=q.pollFirst();
            int i=p[0],j=p[1];

            if(dis[i][j]>=health)return false;

            if(i==m-1&&j==n-1)return true;

            for(int[] d:DIRS){
                int x=i+d[0],y=j+d[1];
                if(x>=0&&x<m&&y>=0&&y<n){
                    int cost=a[x][y];
                    if(dis[i][j]+cost<dis[x][y]) {
                        dis[x][y] = dis[i][j] + cost;
                        if(cost==0) {
                            q.addFirst(new int[]{x, y});
                        }else{
                            q.addLast(new int[]{x, y});
                        }
                    }
                }
            }
        }
    }
}
