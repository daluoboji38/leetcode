package leetCode.dynamicProgramming.Array;

public class subSeqCnt2V2 {
    private static final int MOD = 1000000007;
    public int distinctSubseqII(String s) {
        char[] ch=s.toCharArray();
        int total=1;
        int[] f=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            int c=ch[i]-'a';
            int newAdd=total;
            total=((total+newAdd)%MOD-(f[c]+MOD))%MOD;
            f[c]=newAdd;
        }
        return (total-1+MOD)%MOD;
    }
}
