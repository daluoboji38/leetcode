package leetCode.greedy.String;

public class regexMatch2V2 {
    public boolean isMatch(String s, String p) {
        int p_len = p.length(), s_len = s.length(),s_idx=0,p_idx=0,start=-1,match=0;
        while(s_idx<s_len){
            if(p_idx<p_len && p.charAt(p_idx)!='*' && (isEquals(s.charAt(s_idx), p.charAt(p_idx)))){
                s_idx++;
                p_idx++;
            } else if(p_idx<p_len && p.charAt(p_idx)=='*'){// skip the first occurrence of *
                start = p_idx;
                match = s_idx;
                p_idx++;
            } else if(start!=-1){
                p_idx = start+1;
                s_idx = ++match;
            } else {
                return false;
            }
        }
        while(p_idx<p_len && p.charAt(p_idx)=='*')p_idx++;
        return p_idx==p_len;
    }

    private boolean isEquals(char a, char b) {
        return a == b || b == '?';
    }
}
