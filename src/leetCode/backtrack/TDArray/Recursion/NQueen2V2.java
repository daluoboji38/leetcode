package leetCode.backtrack.TDArray.Recursion;

public class NQueen2V2 {
    public int totalNQueens(int n) {
        return dfs(n,0,0,0,0);
    }

    private int dfs(int n,int row,int col,int d1,int d2){
        if(row == n){return 1;}

        int cnt=0;
        int limit=(1<<n)-1; // available position mask
        int pos=~(col | d1 | d2) & limit; // merge to get available position mask

        while(pos!=0){
            int p=pos& -pos; // get the rightmost 1
            pos-=p;
            cnt+=dfs(n,row+1,col|p,(d1|p)<<1,(d2|p)>>1);
            // d1: ↘ diagonal, d2: ↙ diagonal
        }
        return cnt;
    }
}
