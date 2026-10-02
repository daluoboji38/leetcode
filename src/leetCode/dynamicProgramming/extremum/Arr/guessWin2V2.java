package leetCode.dynamicProgramming.extremum.Arr;

// 石子游戏 II
public class guessWin2V2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n+1];
        int s=0;
        for(int i=n-1;i>=0;i--){
            s+=piles[i];
            for(int m=1;m<=i/2+1;m++){
                if(i+m*2>=n) {
                    f[i][m] = s;
                } else {
                    int mn=Integer.MAX_VALUE;
                    for(int x=1;x<=m*2;x++){
                        mn=Math.min(mn,f[i+x][Math.max(m,x)]);
                    }
                    f[i][m]=s-mn;
                }
            }
        }
        return f[0][1];
    }
}
