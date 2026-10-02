package leetCode.general.String.extreme;

// 括号的最大嵌套深度
public class parenthesesDepth {
    public int maxDepth(String s) {
        int n = s.length();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                cur++;
                res = Math.max(cur, res);
            }else if (s.charAt(i) == ')') {
                cur--;
            }
        }
        return res;
    }
}
