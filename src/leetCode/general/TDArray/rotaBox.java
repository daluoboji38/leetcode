package leetCode.general.TDArray;

// 旋转盒子


public class rotaBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m=boxGrid.length;
        int n=boxGrid[0].length;
        char[][] newBoxGrid=new char[n][m];
        //Variant of rectangle
        /*  for(int i=0;i<m/2+m%2;i++){
            for(int j=0;j<n/2;j++){
                newBoxGrid[j][i]=boxGrid[m-1-i][j];
                newBoxGrid[n-1-j][i]=boxGrid[m-1-i][n-1-j];
                newBoxGrid[n-1-j][m-1-i]=boxGrid[i][n-1-j];
                newBoxGrid[j][m-1-i]=boxGrid[i][j];
            }
        }*/
        for(int i=0;i<m;i++){
            int cur=n;
            for(int j=n-1;j>=0;j--){
                if(boxGrid[m-1-i][j]=='#'){
                    if(j==cur-1) {
                        newBoxGrid[j][i] = '#';
                        cur--;
                    }else{
                        newBoxGrid[cur-1][i] = '#';
                        newBoxGrid[j][i] = '.';
                        cur--;
                    }
                }else {
                    newBoxGrid[j][i] = boxGrid[m - 1 - i][j];
                    if(boxGrid[m-1-i][j]=='*')cur=j;
                }
            }
        }


        return newBoxGrid;
    }
}
