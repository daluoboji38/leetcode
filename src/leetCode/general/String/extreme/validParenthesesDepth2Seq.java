package leetCode.general.String.extreme;

// 有效括号的嵌套深度
public class validParenthesesDepth2Seq {
    public int[] maxDepthAfterSplit(String seq) {
        char[] chars = seq.toCharArray();
        int n = seq.length();
        int[] ans = new int[n];
        int d = 0;
        int md=0;
        for (int i = 0; i < n; ++i) {
            if (chars[i] == '(') {
                d++;
                ans[i] = d;
                md=Math.max(md,d);
            } else {
                ans[i] = d;
                d--;
            }
        }
        md/=2;
        for(int i=0;i<n;i++){
            ans[i]=ans[i]<=md?0:1;
        }
        return ans;
    }
}
