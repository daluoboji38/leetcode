package leetCode.general.String.validation;

// 有效的括号
public class validParenthesesV2 {
    public boolean isValid(String s) {
        if(s.length()%2==1) return false;
        int top=0;
        char[] str = s.toCharArray();
        for(char c:str){
            if(c=='(') str[top++] = ')';
            else if(c=='[') str[top++] = ']';
            else if(c=='{') str[top++] = '}';
            else if(top==0||str[--top]!=c) return false;
        }
        return top==0;
    }
}
