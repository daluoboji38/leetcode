package leetCode.twoPointer.String;

// 跳跃游戏 VII
public class jumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] vis = new boolean[n];
        vis[0] = true;

        int j = 1;
        for (int i = 0; i < n && j < n; i++) {
            if (vis[i] && s.charAt(i) == '0') {
                for (j = Math.max(j, i + minJump); j <= Math.min(i + maxJump, n - 1); j++) {
                    vis[j] = true;
                }
            }
        }
        return vis[n - 1] && s.charAt(n - 1) == '0';
    }
}


