package leetCode.backtrack.String;

import java.util.ArrayList;
import java.util.List;

// 括号生成
public class allParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[2 * n];
        dfs(0, 0, n, path, ans);
        return ans;
    }

    private void dfs(int left, int right,int n, char[] path, List<String> ans) {
        if(right==n){
            ans.add(new String(path));
            return;
        }
        if(left<n){
            path[left + right] = '(';
            dfs(left + 1, right, n, path, ans);
        }
        if(right<left) {
            path[left + right] = ')';
            dfs(left, right + 1, n, path, ans);
        }
    }
}
