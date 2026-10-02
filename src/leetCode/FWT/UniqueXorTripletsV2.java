package leetCode.FWT;

// 不同 XOR 三元组的数目 II
// Walsh Transform (FWT)
public class UniqueXorTripletsV2 {
    int MOD = 1_000_000_007;
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int mx=0;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
        }
        int l=1<<(32-Integer.numberOfLeadingZeros(mx));
        long[] cnt = new long[l];
        for(int x:nums){
            cnt[x]++;
        }
        int ans=0;
        for(long c:fwtXOR3(cnt)){
            if(c>0)ans++;
        }
        return ans;
    }

    // FWT XOR
    private void fwtXOR(long[] a,int rsh) {
        int n = a.length;
        for(int l=2,k=1;l<=n;l<<=1,k<<=1){
            for(int i=0;i<n;i+=l){
                for(int j=0;j<k;j++){
                    long x=a[i+j];
                    long y=a[i+j+k];
                    a[i+j]=(x+y)>>rsh;
                    a[i+j+k]=(x-y)>>rsh;
                }
            }
        }
    }

    private long[] fwtXOR3(long[] a){
        int n = a.length;
        fwtXOR(a,0);
        for(int i=0;i<n;i++){
            long x=a[i]%MOD;
            a[i]=x*x%MOD*x%MOD;

        }// FWT(D)=FWT(A)^3; D=A XOR A XOR A
        fwtXOR(a,1); // IFWT(FWT(A)^3)
        for(int i=0;i<n;i++){
            if(a[i]<0)a[i]+=MOD;
            a[i]%=MOD;
        }
        return a;
    }
}
