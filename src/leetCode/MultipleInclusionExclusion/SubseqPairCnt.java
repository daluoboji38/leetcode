package leetCode.MultipleInclusionExclusion;

// 最大公约数相等的子序列数量
public class SubseqPairCnt {
    private static final int MOD=1_000_000_007;
    private static final int MX=201;

    private static final int[][] lcms=new int[MX][MX];
    private static final int[] pow2=new int[MX];
    private static final int[] pow3=new int[MX];
    private static final int[] mu=new int[MX];
    private static boolean init=false;

    public SubseqPairCnt(){
        if(init){
            return;
        }
        init=true;

        for(int i=1;i<MX;i++){
            for(int j=1;j<MX;j++){
                lcms[i][j]=lcm(i,j);
            }
        }

        pow2[0]=pow3[0]=1;

        for(int i=1;i<MX;i++){
            pow2[i]=pow2[i-1]*2%MOD;
            pow3[i]=(int)((long)pow3[i-1]*3%MOD);
        }

        // Möbius function
        mu[1]=1;
        for(int i=1;i<MX;i++){
            for(int j=i*2;j<MX;j+=i){
                mu[j]-=mu[i];
            }
        }
    }

    public int subsequencePairCount(int[] nums) {
        int m=0;
        for(int x:nums){
            m=Math.max(m,x);
        }

        int[] cnt=new int[m+1];// cnt[1] means the amount of multiples of i in nums.
        for(int x:nums){
            cnt[x]++;
        }
        for(int i=1;i<=m;i++){
            for(int j=i*2;j<=m;j+=i){
                cnt[i]+=cnt[j];
            }
        }

        int[][] f=new int[m+1][m+1]; // This represents the number of subsequence pairs where the GCD of the first subsequence is a multiple of g1, and the GCD of the second subsequence is a multiple of g2.
        for(int g1=1;g1<=m;g1++){
            for(int g2=1;g2<=m;g2++){
                int l=lcms[g1][g2];
                int c=l<=m?cnt[l]:0;
                int c1=cnt[g1];
                int c2=cnt[g2];
                f[g1][g2]=(int)(((long) pow3[c]*pow2[c1+c2-c*2]-pow2[c1]-pow2[c2]+1)%MOD);
            }
        }

        // multiple inclusion exclusion
        long ans=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m/i;j++){
                for(int k=1;k<=m/i;k++){
                    ans+=mu[j]*mu[k]*f[j*i][k*i];
                }
            }
        }
        return (int)((ans%MOD+MOD)%MOD);
    }

    // greatest common divisor
    private static int gcd(int a,int b){
        while(a!=0){
            int temp=a;
            a=b%a;
            b=temp;
        }
        return b;
    }

    // least common multiple
    private static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
}
