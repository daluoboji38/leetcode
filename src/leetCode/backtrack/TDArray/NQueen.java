package leetCode.backtrack.TDArray;

import java.util.ArrayList;
import java.util.List;

// N 皇后
public class NQueen {
    boolean[] row, col, diagonal1, diagonal2;
    boolean[][] board;
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n];
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        board = new boolean[n][n];

        dfs(0, n);
        return res;
    }

    private void dfs(int idx,int n) {
        if(idx == n) {
            res.add(generateBoard(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!row[i] && !col[i] && !diagonal1[idx + i] && !diagonal2[idx - i + n - 1]) {
                board[idx][i] = true;
                row[i] = col[i] = diagonal1[idx + i] = diagonal2[idx - i + n - 1] = true;
                dfs(idx + 1, n);
                board[idx][i] = false;
                row[i] = col[i] = diagonal1[idx + i] = diagonal2[idx - i + n - 1] = false;
            }
        }
    }

    private List<String> generateBoard(boolean[][] board) {
        List<String> output = new ArrayList<>();
        int n = board.length;
        for (boolean[] booleans : board) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (booleans[j]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            output.add(sb.toString());
        }
        return output;
    }
}
