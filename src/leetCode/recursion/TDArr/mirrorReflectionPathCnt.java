package leetCode.recursion.TDArr;

// 统计镜子反射路径数目
public class mirrorReflectionPathCnt {
    private static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int n=grid[0].length;
        int[] f0=new int[n+1];
        int[] f1=new int[n+1];
        f0[1]=f1[1]=1;
        for(int[] row:grid){
            for(int j=0;j<n;j++){
                if(row[j]==0){
                    f0[j+1]=(f0[j]+f1[j+1])%MOD;
                    f1[j+1]=f0[j+1];
                }else{
                    f0[j+1]=f1[j+1];
                    f1[j+1]=f0[j];
                }
            }
        }
        return f0[n];
    }
}
