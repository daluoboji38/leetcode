package leetCode.general.String;

// 最长有效括号
public class lstPar {
    public int longestValidParentheses(String s) {
        int left=0,right=0,ans=0, n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left<right){
                left=right=0;
            }else if(left==right){
                ans=Math.max(ans,right*2);
            }
        }

        left=right=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==')'){
                left++;
            }else{
                right++;
            }
            if(left<right){
                left=right=0;
            }else if(left==right){
                ans=Math.max(ans,right*2);
            }
        }
        return ans;
    }
}
