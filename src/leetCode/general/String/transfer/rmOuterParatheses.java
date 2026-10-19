package leetCode.general.String.transfer;

// 删除最外层的括号
public class rmOuterParatheses {
    public String removeOuterParentheses(String S) {
        char[] s = S.toCharArray();
        int idx=0,dep=0;
        for(char c:s){
            if(c=='(' && ++dep!=1)s[idx++]=c;
            if(c==')' && --dep!=0)s[idx++]=c;
        }
        return new String(s,0,idx);
    }
}
