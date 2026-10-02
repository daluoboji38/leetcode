package leetCode.mathRule.Arr;

// 石子游戏 IV

public class guessWin4 {
    public boolean winnerSquareGame(int n) {
        boolean[] f = new boolean[n+1];
        for(int i = 0; i < n; i++){
            if(f[i])continue;
            for(int x=1;x*x<=n-i;x++)f[i+x*x] = true;
        }
        return f[n];
    }
}
