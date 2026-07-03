package leetCode.general.Array.distinct;
// abbaca
// 删除字符串中的所有相邻重复项
public class rmDuplicate {
    public String removeDuplicates(String s) {
        int left = 0,right=1;
        char[] ch = s.toCharArray();
        int n = ch.length;
        while (right < n-1) {
            if (ch[left] == ch[right]) {
                if(left==0){
                    ch[left] = ch[++right];
                    right++;
                }else{
                    left--;
                    right++;
                }
            }else{
                ch[++left]=ch[right++];
            }
        }
        if(right==n){return new String(ch,left,1);}
        if(ch[left] == ch[right]){
            if(left==0){
                return "";
            }else {
                left--;
            }
        }else{
            ch[++left]=ch[right];
        }
        return new String(ch,0,left+1);
    }
}
