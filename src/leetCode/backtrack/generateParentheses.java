package leetCode.backtrack;
// 括号生成

import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans,new StringBuffer(),0,0,n);
        return ans;
    }

    public void backtrack(List<String> ans,StringBuffer cur,int open,int close,int max){
        if(cur.length() == 2*max){
            ans.add(cur.toString());
        }else{
            if(open < max){
                cur.append("(");
                backtrack(ans,cur,open+1,close,max);
                cur.deleteCharAt(cur.length()-1);
            }
            if(close < open){
                cur.append(")");
                backtrack(ans,cur,open,close+1,max);
                cur.deleteCharAt(cur.length()-1);
            }
        }


    }
}
