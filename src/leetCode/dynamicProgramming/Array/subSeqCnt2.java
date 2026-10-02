package leetCode.dynamicProgramming.Array;

// 不同的子序列 II
public class subSeqCnt2 {
    private static final int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        int total=0;
        int[] f=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            int other=(total-f[c]+MOD)%MOD;
            f[c]=1+total;
            total=(f[c]+other)%MOD;
        }
        return total;
    }
}
