package leetCode.recursion.String;

// 反转每对括号间的子串
public class ReverseParentheses {
    int i=0;
    int n;
    public String reverseParentheses(String s) {
        n=s.length();
        char[] cs = s.toCharArray();
        return getSub(cs);
    }

    private String getSub(char[] cs){
        StringBuilder sb=new StringBuilder();
        while(i<n) {
            if (cs[i] == ')') {
                i++;
                return sb.reverse().toString();
            } else if (cs[i] == '(') {
                i++;
                sb.append(getSub(cs));
            }else {
                sb.append(cs[i++]);
            }
        }
        return sb.toString();
    }
}
