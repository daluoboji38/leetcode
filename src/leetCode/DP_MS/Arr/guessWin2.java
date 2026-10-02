package leetCode.DP_MS.Arr;

import java.util.ArrayDeque;
import java.util.Arrays;

// DP_MS: dynamic programming and monotonic stack
// 石子游戏 II
public class guessWin2 {
    public int stoneGameII(int[] piles) {
        int n  = piles.length;
        int[][] f = new int[n][n+1];
        ArrayDeque<Integer>[] colQ = new ArrayDeque[n+1];
        Arrays.setAll(colQ,_->new ArrayDeque<>());

        for(int i=n-1,s=0;i>=0;i--){
            s+=piles[i];
            ArrayDeque<Integer> diagQ = new ArrayDeque<>();
            // in extreme i=2+4+8+...+M=2M-2
            for(int m=1;m<=i/2+1;m++){
                if(i+m*2>=n) {
                    f[i][m] = s;
                    continue;
                }

                ArrayDeque<Integer> q=colQ[m];
                while(!q.isEmpty() && f[q.peekLast()][m]>=f[i+1][m]){
                    q.pollLast();
                }
                q.offerLast(i+1);

                if(q.peekFirst()>i+m)q.pollFirst();

                for(int x=m*2-1;x<=m*2;x++){
                    while(!diagQ.isEmpty() && f[i+diagQ.peekLast()][diagQ.peekLast()]>=f[i+x][x]){
                        diagQ.pollLast();
                    }
                    diagQ.offerLast(x);
                }

                if(diagQ.peekFirst()<=m){
                    diagQ.pollFirst();
                }

                f[i][m]=s-Math.min(f[q.peekFirst()][m], f[i+diagQ.peekFirst()][diagQ.peekFirst()]);
            }
        }
        return f[0][1];
    }
}
