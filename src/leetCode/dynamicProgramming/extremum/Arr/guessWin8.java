package leetCode.dynamicProgramming.extremum.Arr;

// 石子游戏 VIII
public class guessWin8 {
    public int stoneGameVIII(int[] stones) {
        int sum=0;
        for(int x:stones) sum+=x;

        int f=sum;
        for(int i=stones.length-2;i>=0;i--){
            sum-=stones[i+1];
            f=Math.max(f,sum-f);
        }
        return f;
    }
}
