package leetCode.dfs;

// 跳跃游戏 III
public class
jumpGame2 {
    public boolean canReach(int[] arr, int start) {
        int m=arr.length;
        boolean[] dp = new boolean[m];
        return dfs(arr, start, dp);
    }

    private boolean dfs(int[] arr, int start, boolean[] dp) {
        if (start < 0 || start >= arr.length || dp[start]) {
            return false;
        }
        if(arr[start]==0){
            return true;
        }
        dp[start]=true;
        return dfs(arr, start-arr[start], dp) || dfs(arr, start+arr[start], dp);
    }
}
