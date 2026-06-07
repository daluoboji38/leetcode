package leetCode.backtrack.TDArray;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 解数独
public class sudokuSolve {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        List<int[]> emptyPos = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    emptyPos.add(new int[]{i, j});
                }else {
                    int x=board[i][j]-'1';
                    row[i][x] =col[j][x]=box[i/3][j/3][x]= true;
                }
            }
        }

        PriorityQueue<int[]> emptyPQ = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int[] pos : emptyPos) {
            int i = pos[0];
            int j = pos[1];
            int candidates=getCandidates(i,j,row,col,box);
            emptyPQ.offer(new int[]{candidates,i,j});
        }

        dfs(board,row,col,box,emptyPQ);
    }

    // remaining option for one position
    private int getCandidates(int i,int j,boolean[][] row,boolean[][] col,boolean[][][] box) {
         int candidate = 9;
         for(int x=0;x<9;x++){
             if(row[i][x] || col[j][x] || box[i/3][j/3][x]){candidate--;}
         }
        return candidate;
    }


    private boolean dfs(char[][] board,boolean[][] row,boolean[][] col,boolean[][][] box, PriorityQueue<int[]> emptyPQ) {
        if(emptyPQ.isEmpty()) return true;

        int[] top = emptyPQ.poll();
        int i = top[1];
        int j = top[2];

        int candidates=0;
        for(int x=0;x<9;x++){
            if(row[i][x] ||  col[j][x] || box[i/3][j/3][x]){continue;}

            board[i][j]=(char)(x+'1');
            row[i][x] =col[j][x]=box[i/3][j/3][x]=true;

            if(dfs(board,row,col,box,emptyPQ)) return true;

            row[i][x] =col[j][x]=box[i/3][j/3][x]=false;
            candidates++;
        }

        emptyPQ.offer(new int[]{candidates,i,j});
        return false;
    }
}
