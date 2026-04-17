package leetCode.dynamicProgramming;
// 正则表达式匹配
public class regexMatch {
    String text, pattern;
    public boolean isMatch(String s, String p) {
        text = s;
        pattern = p;
        boolean[][] dp = new boolean[text.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for(int i=0; i<=text.length(); i++){
            for(int j=1; j<=pattern.length(); j++){
                if (pattern(j)!='*'){
                    if(isEqual(i,j))
                        dp[i][j] = dp[i-1][j-1];// dp[i][j] represent if the first j length pattern match the first i length txt
                }else{
                    if(isEqual(i,j-1)){
                        dp[i][j]=dp[i-1][j];  // if txt match *anyChar pattern, result depend on i-1 length txt and j length pattern
                    }else{dp[i][j]=dp[i][j-2];}; // if txt not match *anyChar pattern(*anyChar is removed), result depend on i length txt and j-2 length pattern
                    dp[i][j]=dp[i][j] || dp[i][j-2]; // disregard *anyChar pattern
                }
            }
        }
        return dp[text.length()][pattern.length()];
    }
    private boolean isEqual(int x, int y){
        if(x==0) return false;
        if(pattern(y)=='.') return true;
        return text(x)==pattern(y);
    }

    private char text(int x){
        return text.charAt(x-1);
    }
    private char pattern(int y){
        return pattern.charAt(y-1);
    }

}
