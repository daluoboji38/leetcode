package leetCode.general.TDArray;

import java.util.ArrayList;
import java.util.List;

// 循环轮转矩阵
// arrayList is slower than int array
public class circRotMat {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m= grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int round = Math.min(m,n)/2;
        for(int d=0; d<round; d++){
            int[] arr = new int[(n+m-d*4-2)*2];
            int idx=0;
            for(int j=d; j<n-d; j++) arr[idx++]=(grid[d][j]); // up
            for(int i=d+1; i<m-d; i++) arr[idx++]=(grid[i][n-1-d]); // right
            for(int j=n-2-d; j>=d; j--) arr[idx++]=(grid[m-1-d][j]); // down
            for(int i=m-2-d; i>d; i--) arr[idx++]=(grid[i][d]); // left

            int shift = k % arr.length;
            int[] shifted = new int[arr.length];
            System.arraycopy(arr, shift, shifted, 0, arr.length - shift);
            System.arraycopy(arr, 0, shifted, arr.length - shift, shift);
            idx=0;
            for(int i=d; i<n-d; i++) res[d][i]=shifted[idx++];
            for(int i=d+1; i<m-d; i++) res[i][n-1-d]=shifted[idx++];
            for(int i=n-2-d; i>=d; i--) res[m-1-d][i]=shifted[idx++];
            for(int i=m-2-d; i>d; i--) res[i][d]=shifted[idx++];
        }
        return res;
    }
}
// 2+7+1+6
// 4+9+3+8