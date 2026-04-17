package leetCode.general.String;
// 字符串转换整数
public class atoi {
    public int myAtoi(String s) {
        s = s.trim();
        char prefix='+';

        if(s.startsWith("+") || s.startsWith("-")){
            prefix = s.charAt(0);
            s = s.substring(1);
        }
        if(s.isEmpty() || !Character.isDigit(s.charAt(0)))return 0;
        else{
            long result = 0;
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    if(result>(Long.MAX_VALUE-(s.charAt(i)-'0'))/10) result= Integer.MAX_VALUE;
                    //  -9223372036854775808, 9223372036854775807
                    result = result*10 + (s.charAt(i)-'0');
                }else{
                    break;
                }
            }
            if(prefix == '-') result = -result;
            if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return (int) result;
        }
    }
}
