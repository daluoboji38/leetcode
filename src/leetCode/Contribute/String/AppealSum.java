package leetCode.Contribute.String;

import java.util.Arrays;

// 字符串的总引力
public class AppealSum {
    public long appealSum(String s) {
        int[] last=new int[26];
        Arrays.fill(last,-1);
        int n=s.length();
        long ans=0;
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            ans+=(long)(i-last[c])*(n-i);
            last[c]=i;
        }
        return ans;
    }
}
