package leetCode.backtrack.String;

import java.util.ArrayList;
import java.util.List;

// 删除无效的括号
public class rmInvalidParentheses {
    int n;
    public List<String> removeInvalidParentheses(String S) {
        char[] s = S.toCharArray();
        n = s.length;
        int target=0,left=0;
        for(char c:s){
            if(c=='('){
                target++;
                left++;
            }else if(c==')' && left>0){
                left--;
            }
        }
        target-=left;
        List<String> ans = new ArrayList<>();
        dfs(0,0,0,ans,new StringBuilder(),s,target);
        return ans;
    }

    private void dfs(int i,int left,int right,List<String> ans,StringBuilder path,char[] s,int target){
        if(left<right || left>target || right+left+n-i<target*2){return;}
        if(i==n){
            ans.add(path.toString());
            return;
        }
        char ch = s[i];
        // not choose
        if(ch=='(' || ch==')'){
            int j=i+1;
            while(j<n && s[j]==ch){j++;}
            dfs(j,left,right,ans,path,s,target);
        }

        // choose
        if(ch=='('){
            left++;
        }else if(ch==')'){
            right++;
        }
        path.append(ch);
        dfs(i+1,left,right,ans,path,s,target);
        path.deleteCharAt(path.length()-1);
    }
}
