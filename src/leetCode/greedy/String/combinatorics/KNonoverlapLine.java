package leetCode.greedy.String.combinatorics;

// 大小为 K 的不重叠线段的数目
public class KNonoverlapLine {
    private static final int MOD = 1000000007;
    private static final int MX=1999;

    private static final long[] F=new long[MX];
    private static final long[] INV_F=new long[MX];

    private static boolean initialized;

    public KNonoverlapLine(){
        if(initialized)return;
        initialized=true;

        F[0]=1;
        for(int i=1;i<MX;i++){
            F[i]=F[i-1]*i%MOD;
        }

        INV_F[MX-1]=pow(F[MX-1],MOD-2);
        for(int i=MX-1;i>0;i--){
            INV_F[i-1]=INV_F[i]*i%MOD;
        }
    }

    private long pow(long x, int n){
        long res=1;
        for(;n>0;n/=2){
            if(n%2==1){
                res=res*x%MOD;
            }
            x=x*x%MOD;
        }
        return res;
    }

    private long comb(int n,int m){
        return F[n]*INV_F[m]%MOD*INV_F[n-m]%MOD;
    }

    public int numberOfSets(int n, int k) {
        return (int)comb(n+k-1,k*2);
    }
}
