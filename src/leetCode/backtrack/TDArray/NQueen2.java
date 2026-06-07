package leetCode.backtrack.TDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// N 皇后 II
public class NQueen2 {
    boolean[] col,diagonal1,diagonal2;
    int[] board;
    int res=0;
    public int totalNQueens(int n) {
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        board=new int[n];
        dfs(0,n);
        return res;
    }

    void dfs(int row,int n){
        if(row == n){
            res++;
        }
        for(int i=0;i<n;i++){
            if(col[i] || diagonal1[row-i+n-1] || diagonal2[row+i]){continue;}
            board[row] = i;
            col[i] = diagonal1[row-i+n-1] = diagonal2[row+i] = true;
            dfs(row + 1, n);
            col[i] = diagonal1[row-i+n-1] = diagonal2[row+i] = false;
        }
    }
}
