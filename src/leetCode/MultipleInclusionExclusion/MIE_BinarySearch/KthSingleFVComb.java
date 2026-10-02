package leetCode.MultipleInclusionExclusion.MIE_BinarySearch;

import java.util.Arrays;

// 单面值组合的第 K 小金额
public class KthSingleFVComb {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int n=0;
        next:
        for(int x:coins){
            for(int j=0;j<n;j++){
                if(x%coins[j]==0){
                    continue next;
                }
            }
            coins[n++]=x;
        }

        long[] subsetLcm=new long[1<<n];
        subsetLcm[0]=1;
        for(int i=0;i<n;i++){
            int bit=1<<i;
            for(int mask=0;mask<bit;mask++){
                subsetLcm[bit | mask]=lcm(subsetLcm[mask],coins[i]);
            }
        }
        for(int i=1;i<subsetLcm.length;i++){
            if(Integer.bitCount(i)%2==0)subsetLcm[i]*=-1;
        }

        long left =k-1;
        long right=(long)coins[0]*k;
        while(left+1<right){
            long mid=left+(right-left)/2;
            if(check(mid,subsetLcm,k)){
                right=mid;
            }else {
                left=mid;
            }
        }
        return right;
    }

    private boolean check(long m,long[]subsetLcm,int k){
        long cnt=0;
        for(int i=1;i<subsetLcm.length;i++){
            cnt+=m/subsetLcm[i];
        }
        return cnt>=k;
    }

    private long gcd(long a,long b){
        while(a!=0){
            long tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }

    private long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
}
