package leetCode.DSU.BFS;

// 两个城市间路径的最小分数
public class minPathV2 {
    private int[] parent;
    private int[] minEdge;

    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        minEdge = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            minEdge[i] = Integer.MAX_VALUE;
        }

        for (int[] road : roads) {
            union(road[0], road[1], road[2]);
        }
        return minEdge[find(1)];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y, int edge) {
        int rootX = find(x);
        int rootY = find(y);
        int min = Math.min(minEdge[rootX], Math.min(minEdge[rootY], edge));

        if (rootX == rootY) {
            minEdge[rootX] = min;
            return;
        }

        parent[rootX] = rootY;
        minEdge[rootY] = min;
    }

}
