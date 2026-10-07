package leetCode.general.String.extreme;

// 最长有效括号
public class lstPairV2 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if(n==0) return 0;
        if(n==1) return 0;
        int[] dp = new int[n+1];
        int ans=0;
        for(int i=2;i<=n;i++){
            if(s.charAt(i-1)==')'){
                if(s.charAt(i-2)=='('){
                    dp[i]=dp[i-2]+2;
                }else if(i-dp[i-1]-2>=0 && s.charAt(i-dp[i-1]-2)=='('){
                    dp[i]=dp[i-1]+2;
                    dp[i]+=dp[i-dp[i-1]-2];
                }
                ans=Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}
