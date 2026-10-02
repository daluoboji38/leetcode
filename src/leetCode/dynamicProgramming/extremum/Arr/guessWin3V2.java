package leetCode.dynamicProgramming.extremum.Arr;

// 石子游戏 III
public class guessWin3V2 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] f = new int[n + 3];
        int sufSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufSum += stoneValue[i];
            f[i] = sufSum - Math.min(f[i + 1], Math.min(f[i + 2], f[i + 3]));
        }
        int diff = f[0] * 2 - sufSum;
        if (diff == 0) {
            return "Tie";
        }
        return diff > 0 ? "Alice" : "Bob";
    }
}
