package leetCode.DP_SlidW.extremum;

import java.util.ArrayDeque;
import java.util.Deque;

// 石子游戏 III
public class guessWin3 {
    public String stoneGameIII(int[] stoneValue) {
        final int k=3;
        int n=stoneValue.length;
        int[] f=new int[n+1];
        Deque<Integer> q=new ArrayDeque<>();
        q.offerLast(n);
        int sufSum=0;
        for(int i=n-1;i>=0;i--){
            sufSum+=stoneValue[i];

            // right out, make sure window index between [i+1, i+k]
            if(q.peekLast()>i+k){q.pollLast();}

            // calculation transfer
            f[i]=sufSum-f[q.peekLast()];

            // left in, maintain decreasing order
            while(!q.isEmpty()&&f[q.peekFirst()]>=f[i]){q.pollFirst();}
            q.offerFirst(i);
        }

        int diff=f[0]*2-sufSum;
        if(diff==0){return "Tie";}
        return diff>0?"Alice":"Bob";
    }
}
