package leetCode.Manacher.extreme;

import java.util.Arrays;

// 不重叠回文子字符串的最大数目
public class NonOverlapPalindromes {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] t= new char[2*n+3];
        Arrays.fill(t, '#');
        t[0] = '^';
        for(int i=0;i<n;i++)
            t[2*i+2] = s.charAt(i);
        t[2*n+2] = '$';

        int[] halfLen=new int[t.length-2];
        halfLen[1]=1;

        int boxM=0;
        int boxR=0;
        for(int i=2;i<halfLen.length;i++){
            int hl=1;
            if(i<boxR)hl=Math.min(boxR-i,halfLen[boxM * 2 - i]);
            while(t[i+hl]==t[i-hl]){
                hl++;
                boxM=i;
                boxR=i+hl;
            }
            halfLen[i]=hl;
        }

        int ans=0;
        for(int i=0;i<=n-k;){
            if(isPalindrome(halfLen,i,i+k-1)){
                ans++;
                i+=k;
            }else if(i<n-k && isPalindrome(halfLen,i,i+k)){
                ans++;
                i+=k+1;
            }else{
                i++;
            }
        }
        return ans;
    }

    private boolean isPalindrome(int[] halfLen, int l, int r) {
        return halfLen[l+r+2]>r-l+1;
    }
}
