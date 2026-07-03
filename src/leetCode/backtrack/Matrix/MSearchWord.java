package leetCode.backtrack.Matrix;

// 单词搜索
public class MSearchWord {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length,n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] vis) {
        if (index == word.length() - 1) return true;

        vis[x][y] = true;
        for (int[] dir : dir) {
            int newx = x + dir[0], newy = y + dir[1];
            if (newx >= 0 && newx < board.length
                    && newy >= 0 && newy < board[0].length
                    && !vis[newx][newy] && board[newx][newy] == word.charAt(index + 1)) {
                if (dfs(board, word, index + 1, newx, newy, vis)) return true;
            }
        }
        vis[x][y] = false;

        return false;
    }
}
