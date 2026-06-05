package leetCode.backtrack.TDArray.Recursion;

public class NQueen2V2 {
    public int totalNQueens(int n) {

    }

    private int dfs(int n,int row,int col,int d1,int d2){
        if(row == n){return 1;}

        int cnt=0;
        int limit=(1<<n)-1; // available position mask
        int pos=~(col | d1 | d2) & limit;


    }
}
