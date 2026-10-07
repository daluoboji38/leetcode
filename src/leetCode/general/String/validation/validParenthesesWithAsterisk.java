package leetCode.general.String.validation;

// 有效的括号字符串
public class validParenthesesWithAsterisk {
    public boolean checkValidString(String s) {
        int cnt=0;
        int acnt=0;
        char[] str = s.toCharArray();
        for(char c:str){
            if(c=='*') {
                acnt++;
            }else if(c=='('){
                cnt++;
            }else {
                cnt--;
            }
            if(cnt+acnt<0) return false;
        }
        int cntr=0;
        int acntr=0;
        for(int i= str.length-1;i>=0;i--){
            if(str[i]=='*') {
                acntr++;
            }else if(str[i]=='('){
                cntr--;
            }else {
                cntr++;
            }
            if(cntr+acntr<0) return false;
        }
        return cnt <= acnt && cntr<=acntr;
    }
}
