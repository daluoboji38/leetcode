package leetCode.DSU.TDArr;

import java.util.ArrayList;
import java.util.List;

// 找出最安全路径
// DSU = Disjoint Set Union 并查集
public class mostSafePath {
    private final static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int[] fa;
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dis = new int[n][n];
        List<int[]> q = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;// dis[i][j] denote the Manhattan distance from cell (i, j) to the nearest cell with value 1.
                }
            }
        }

        List<List<int[]>> groups = new ArrayList<List<int[]>>();// group the dis[i][j] with same value
        groups.add(q);
        while (!q.isEmpty()) {
            List<int[]> tmp=q;
            q=new ArrayList<>();
            for (int[] p : tmp) {
                for (int[] d : DIRS) {
                    int x = p[0] + d[0],y = p[1] + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && dis[x][y] == -1) {
                        dis[x][y] = groups.size();
                        q.add(new int[]{x, y});
                    }
                }
            }
            groups.add(q);
        }

        fa=new int[n*n];
        for (int i = 0; i < n * n; i++) {
            fa[i] = i;
        }

        for(int ans = groups.size() - 2; ans > 0; ans--) {
            for (int[] p : groups.get(ans)) {
                for (int[] d : DIRS) {
                    int x = p[0] + d[0],y = p[1] + d[1];
                    if (x >= 0 && x < n && y >= 0 && y < n && dis[x][y] >=ans) {
                        fa[find(x * n + y)] = find(p[0] * n + p[1]);
                    }
                }
            }
            if (find(0) == find(n * n - 1)) {
                return ans;
            }
        }
        return 0;
    }

    private int find(int x) {
        if (fa[x] != x) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
