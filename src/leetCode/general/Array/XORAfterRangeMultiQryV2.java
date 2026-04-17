package leetCode.general.Array;

public class XORAfterRangeMultiQryV2 {
    private static final int MOD = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long n=1, n2_0=1;
        for(int[] query:queries){
            if(query[2]==1&&query[0]==0&&query[1]==nums.length-1){
                n*=query[3];
                if(n>=MOD){
                    n%=MOD;
                }
            }else if(query[2]==2&&query[0]==0&&query[1]==nums.length-1){
                n2_0*=query[3];
                if(n2_0>=MOD){
                    n2_0%=MOD;
                }
            }else {
                for(int i=query[0];i<query[1];i+=query[2]){
                    long val=(long)nums[i]*query[3];
                    if(val>=MOD){
                        val%=MOD;
                    }
                    nums[i]=(int)val;
                }
            }
        }

        int re=(int)(((((long)nums[0]*n)%MOD)*n2_0)%MOD);
        for(int j=1;j<nums.length;j++){
            long temp=((long)nums[j]*n)%MOD;
            if(j%2==0){
                temp=(temp*n2_0)%MOD;
            }
            re^=temp;
        }
        return re;
    }
}
