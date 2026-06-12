package leetCode.general.TDArray.MultiplePointer;

// 螺旋矩阵 II
public class spiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1,idx=1;
        while(true){
            for(int i = l; i <= r; i++) res[u][i] = idx++;
            if(++u > d) break;
            for(int i = u; i <= d; i++) res[i][r] = idx++;
            if(--r < l) break;
            for(int i = r; i >= l; i--) res[d][i] = idx++;
            if(--d < u) break;
            for(int i = d; i >= u; i--) res[i][l] = idx++;
            if(++l > r) break;
        }
        return res;
    }
}
