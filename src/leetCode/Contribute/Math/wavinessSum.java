package leetCode.Contribute.Math;

// 范围内总波动值 I
public class wavinessSum {
    public long totalWaviness(long num1, long num2) {
        return calc(num2)-calc(num1-1);
    }

    private long calc(long n){
        long ans=0;

        // divide long longo 5 segments orefix | l | m | r | suffix
        for(long pow10=1;n>pow10*100;pow10*=10){
            long maxPrefix = n / (pow10 * 1000);
            long n2=n/pow10;
            int L=(int)(n2/100%10);
            int M=(int)(n2/10%10);
            int R=(int)(n2%10);

            // case 1: prefix<maxPrefix
            // illegal when prefix=0 and l=0. amount=45
            long cnt=maxPrefix*570-45;

            // case 2: prefix==maxPrefix and l<L
            cnt+=(121+L*15-L*L)*L/3;

            // case 3: prefix==maxPrefix and l=L and m<M
            cnt+=(L+M)*Math.max(M-L-1,0)/2; // peak
            cnt+=(19-Math.min(L,M))*Math.min(L,M)/2; // trough

            // case 4: prefix==maxPrefix and l=L and m=M and r<R
            if(L<M){
                cnt+=Math.min(M,R);
            }else if(L>M){
                cnt+=Math.max(R-M-1,0);
            }

            ans+=cnt*pow10;

            // case 5: prefix==maxPrefix and l=L and m=M and r=R
            if((L-M)*(M-R)<0){
                long maxSuffix = n % pow10;
                ans+=maxSuffix+1;
            }
        }
        return ans;
    }

}
