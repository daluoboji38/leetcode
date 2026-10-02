package leetCode.dynamicProgramming.String;

import java.util.Arrays;

// 判断子序列
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int n=t.length();
        int[][] nxt=new int[n+1][26]; // nxt[i][c] present the closest index of c at index>=i
        Arrays.fill(nxt[n],n);
        for(int i =n-1;i>=0;i--){
            nxt[i]=nxt[i+1].clone();
            nxt[i][t.charAt(i)-'a']=i;
        }

        int i=-1;
        for(char c:s.toCharArray()){
            i=nxt[i+1][c-'a'];
            if(i==n)return false;
        }
        return true;
    }
}
