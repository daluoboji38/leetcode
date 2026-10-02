package leetCode.twoPointer.String;

import java.util.Arrays;

// 不同字符的最小子序列
public class allCharSubseq {
    public String smallestSubsequence(String s) {
        char[] arr = s.toCharArray();
        int[] left =new int[26];
        for(char c:arr){
            left[c-'a']++;
        }

        StringBuilder ans=new StringBuilder();
        boolean[] inAns = new boolean[26];
        for(char c:arr){
            left[c-'a']--;
            if(inAns[c-'a']){continue;}
            while(!ans.isEmpty() && c<ans.charAt(ans.length()-1) && left[ans.charAt(ans.length()-1)-'a']>0){
                inAns[ans.charAt(ans.length()-1)-'a']=false;
                ans.deleteCharAt(ans.length()-1);
            }
            ans.append(c);
            inAns[c-'a']=true;
        }
        return ans.toString();
    }
}
