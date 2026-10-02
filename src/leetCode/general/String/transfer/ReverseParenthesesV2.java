package leetCode.general.String.transfer;

// // 反转每对括号间的子串
public class ReverseParenthesesV2 {
    public String reverseParentheses(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] links=new int[n];
        int[] stack=new int[n];
        int top=-1;

        for(int i=0;i<n;i++){
            char c=cs[i];
            if(c=='('){
                stack[++top]=i;
            }else if(c==')'){
                int j=stack[top--];
                links[i]=j;
                links[j]=i;
            }
        }

        StringBuilder ans=new StringBuilder();
        int step=1;
        for(int i=0;i<n;i+=step){
            char c=cs[i];
            if(c=='(' || c==')'){
                i=links[i];
                step=-step;
            }else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
