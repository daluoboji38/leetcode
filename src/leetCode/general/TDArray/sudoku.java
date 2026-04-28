package leetCode.general.TDArray;

// 有效的数独
public class sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {continue;}
                int num=c-'1';
                if(row[i][num] ||  col[j][num] || box[i/3][j/3][num]){return false;}
                row[i][num] = col[j][num] = box[i/3][j/3][num] = true;
            }
        }
        return true;
    }
}
