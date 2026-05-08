package leetCode.general.TDArray;

// 旋转图像
public class rotaImage {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<m/2+m%2;i++){
            for(int j=0;j<m/2;j++){
                int temp=matrix[m-1-j][i];
                matrix[m-1-j][i]=matrix[m-1-i][m-1-j];
                matrix[m-1-i][m-1-j]=matrix[j][m-1-i];
                matrix[j][m-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}
