package leetCode.general.String;
// 最长回文子串
public class longestPalindromeSearch {
    public String longestPalindrome(String s) {
        int max=0;
        String res=s.substring(0,1);
        for(int i=1;i<s.length();i++){
            int left=i,right=i;
            while(left>0 && right<s.length()-1 && s.charAt(left-1)==s.charAt(right+1)){
                left--;
                right++;
            }
            if(right-left+1>max){
                max=right-left+1;
                res=s.substring(left,right+1);
            }
            if(s.charAt(i-1)==s.charAt(i)){
                left=i-1;right=i;
                while(left>0 && right<s.length()-1 && s.charAt(left-1)==s.charAt(right+1)){
                    left--;
                    right++;
                }
                if(right-left+1>max){
                    max=right-left+1;
                    res=s.substring(left,right+1);

                }
            }
        }

        return res;
    }
}
