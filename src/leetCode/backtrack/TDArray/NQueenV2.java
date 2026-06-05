package leetCode.backtrack.TDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenV2 {
    List<List<String>> res = new ArrayList<>();
    boolean[] col,diagonal1,diagonal2;
    int[] ans;
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        diagonal1 = new boolean[2 * n - 1];
        diagonal2 = new boolean[2 * n - 1];
        ans=new int[n];
        dfs(0,n);
        return res;
    }

    void dfs(int row,int n){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                char[] ch=new char[n];
                Arrays.fill(ch,'.');
                ch[ans[i]]='Q';
                list.add(new String(ch));
            }
            res.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(col[i] || diagonal1[row-i+n-1] || diagonal2[row+i]){continue;}
            ans[row] = i;
            col[i] = diagonal1[row-i+n-1] = diagonal2[row+i] = true;
            dfs(row + 1, n);
            col[i] = diagonal1[row-i+n-1] = diagonal2[row+i] = false;
        }
    }
}
