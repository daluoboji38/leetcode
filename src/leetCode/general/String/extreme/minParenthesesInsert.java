package leetCode.general.String.extreme;

// 平衡括号字符串的最少插入次数
public class minParenthesesInsert {
    public int minInsertions(String S) {
        char[] s=S.toCharArray();
        int ans=0;
        int left=0;
        int n=s.length;

        for(int i=0;i<n;i++){
            if(s[i]=='('){
                left++;
                continue;
            }
            if(left>0){
                left--;
            }else{
                ans++;
            }
            if(i<n-1&&s[i+1]==')'){
                i++;
            }else {
                ans++;
            }
        }
        return ans+left*2;
    }
}
