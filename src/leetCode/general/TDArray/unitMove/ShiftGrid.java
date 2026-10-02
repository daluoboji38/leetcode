package leetCode.general.TDArray.unitMove;

import java.util.ArrayList;
import java.util.List;

// 二维网格迁移
// swap issue
public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size=m*n;
        k%=size;
        reverse(grid,n,0,size-1);
        reverse(grid,n,0,k-1);
        reverse(grid,n,k,size-1);

        // TDArr to List solution
        List<List<Integer>> ans=new ArrayList<>(m);
        for(int[] row:grid){
            List<Integer> r=new ArrayList<>();
            for(int i=0;i<n;i++){
                r.add(row[i]);
            }
            ans.add(r);
        }
        return ans;
    }

    private void reverse(int[][] grid,int n,int l,int r) {
        while (l < r) {
            int x1=l/n;
            int y1=l%n;
            int x2=r/n;
            int y2=r%n;
            int tmp=grid[x1][y1];
            grid[x1][y1]=grid[x2][y2];
            grid[x2][y2]=tmp;
            l++;
            r--;
        }
    }
}
