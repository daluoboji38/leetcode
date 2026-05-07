package leetCode.general.TDArray;

import java.util.Arrays;

// 获取单值网格的最小操作数
// The median minimizes the sum of distances to all data points.
public class singleValueGrid {
    public int minOperations(int[][] grid, int x) {
        int k=grid.length*grid[0].length;
        int[] a=new int[k];
        int idx=0;
        int target=grid[0][0] % x;

        for(int[] row:grid){
            for(int v:row){
                if(v%x!=target){return -1;}
                a[idx++]=v;
            }
        }

        Arrays.sort(a);
        int median=a[k/2];

        int ans=0;
        for(int v:a){
            ans+=Math.abs(v-median);
        }
        return ans/x;
    }
}
