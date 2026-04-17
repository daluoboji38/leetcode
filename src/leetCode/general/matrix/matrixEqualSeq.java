package leetCode.general.matrix;

// 统计 X 和 Y 频数相等的子矩阵数量

public class matrixEqualSeq {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid[0].length;
        int[][] colCnt = new int[n][2];
        int ans = 0;
        for (char[] row : grid){
            int c0 = 0;
            int c1 = 0;
            for(int j=0;j<n;j++){
                if(row[j]!='.') {
                    colCnt[j][row[j] & 1]++;
                }
                c0+=colCnt[j][0];
                c1+=colCnt[j][1];
                if(c0>0 && c0==c1) ans++;
            }
        }
        return ans;
    }
}
