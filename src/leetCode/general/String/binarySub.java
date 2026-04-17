package leetCode.general.String;

// 计数二进制子串
// "10101"
public class binarySub {
    public int countBinarySubstrings(String s) {
        int last=0,cur=0, res=0;
        char[] str=s.toCharArray();
        for(int i=0;i<str.length;i++){
            cur++;
            if (i==s.length()-1 || str[i]!=str[i+1]){
                res+=Math.min(last,cur);
                last=cur;
                cur=0;
            }
        }
        return res;
    }
}
