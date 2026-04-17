package leetCode.general.PPArray;

// 重新排列后的最大子矩阵

import java.util.Arrays;

public class largestBinaryMatrix {
    public int largestSubmatrix(int[][] matrix) {
        // row is fixed, while columns can be rearranged in any order.
        int n=matrix.length; // column length
        int m=matrix[0].length; // row length
        int res =0;
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    matrix[i][j]+=matrix[i-1][j]; // preprocess column to record column length of continuous 1, the value means the length extend toward up direction from this point
                }
            }
        }
        for(int i=0;i<n;i++){
            Arrays.sort(matrix[i]);
            for(int j=m-1;j>=0;j--){
                int height = matrix[i][j];
                res=Math.max(res,height*(m-j));
            }
        }
        return res;
    }
}
