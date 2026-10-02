package leetCode.dynamicProgramming.extremum.Arr;

// 石子游戏 IV
public class guessWin4 {
    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n+1];
        for(int i = 1; i <= n; ++i){
            for(int x=1;x*x<=i;++x){
                if(!f[i-x*x]){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
