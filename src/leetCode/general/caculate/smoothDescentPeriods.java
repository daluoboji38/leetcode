package leetCode.general.caculate;
// 股票平滑下跌阶段的数目


public class smoothDescentPeriods {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        int factorial = 1;
        long ans=0;
        if(n==1) return 1;
        for(int i=0;i<=n-1;i++){
            if(i<n-1 && prices[i+1]==prices[i]-1){
                factorial++;
            }else if(factorial!=1){
                ans += (long) factorial*(factorial -1)/2;
                factorial=1;
            }
        }
        return ans+n;
    }
}
