package leetCode.general.TDArray.unitMove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 二维网格迁移
// swap issue
public class ShiftGridV2 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        k=-k%size+size;
        int[][] a = new int[m][n];
        for(int i=k;i<k+size;i++){
            a[(i-k)/n][(i-k)%n]=grid[i%size/n][i%size%n];
        }
        // TDArr to List solution 2
        List ans= Arrays.asList(a);
        return ans;
    }
}
