package leetCode.general.TDArray;

import java.util.ArrayList;
import java.util.List;

// 螺旋矩阵
public class spiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int u=0,d = matrix.length-1, l=0,r = matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(true){
            for(int i=l;i<=r;i++) ans.add(matrix[u][i]);
            if(++u>d) break;
            for(int i=u;i<=d;i++) ans.add(matrix[i][r]);
            if(--r<l) break;
            for(int i=r;i>=l;i--) ans.add(matrix[d][i]);
            if(--d<u) break;
            for(int i=d;i>=u;i--) ans.add(matrix[i][l]);
            if(++l>r) break;
        }
        return ans;
    }
}
