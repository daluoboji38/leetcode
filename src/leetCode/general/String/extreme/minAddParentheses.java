package leetCode.general.String.extreme;

// 使括号有效的最少添加

public class minAddParentheses {
    public int minAddToMakeValid(String S) {
        char[] s = S.toCharArray();
        int ans=0,cur=0;
        for(char c:s){
            if(c=='('){
                cur++;
            }else{
                if(cur==0){
                    ans++;
                }else{
                    cur--;
                }
            }
        }
        cur=0;
        for(int i=s.length-1;i>=0;i--){
            if(s[i]==')'){
                cur++;
            }else{
                if(cur==0){
                    ans++;
                }else{
                    cur--;
                }
            }
        }
        return ans;
    }
}