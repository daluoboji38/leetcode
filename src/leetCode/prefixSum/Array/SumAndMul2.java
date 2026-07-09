package leetCode.prefixSum.Array;

// 连接非零数字并乘以其数字和 II


public class SumAndMul2 {
    private static final int MOD = 1_000_000_007;
    private static final int MAX_N=100_001;
    private static final int[] pow10 = new int[MAX_N];
    private static boolean initialized=false;

    public SumAndMul2(){
        if(initialized){return;}
        initialized=true;

        pow10[0] = 1;
        for (int i = 1; i < MAX_N; i++) {
            pow10[i] = (int)(pow10[i - 1] * 10L % MOD);
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] sumD=new int[n+1];
        int[] preNum=new int[n+1];
        int[] sumNonZero=new int[n+1];
        for(int i=0;i<n;i++){
            int d = s.charAt(i) - '0';
            sumD[i+1]=sumD[i]+d;
            preNum[i+1]=d>0?(int)((preNum[i]*10L+d)%MOD):preNum[i];
            sumNonZero[i+1]=sumNonZero[i]+(d>0?1:0);
        }

        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0],r=queries[i][1]+1;
            int length=sumNonZero[r]-sumNonZero[l];
            long x=preNum[r]-(long)preNum[l]*pow10[length]%MOD+MOD;
            ans[i]=(int)(x*(sumD[r]-sumD[l])%MOD);
        }
        return ans;
    }
}
