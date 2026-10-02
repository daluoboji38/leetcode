package leetCode.general.String.letter;

// 判断子序列
public class IsSubsequenceV2 {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty())return true;
        int i=0;
        for(char c:t.toCharArray()){
            if(s.charAt(i)==c && ++i==s.length())return true;
        }
        return false;
    }
}
