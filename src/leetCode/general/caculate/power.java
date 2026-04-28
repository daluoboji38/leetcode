package leetCode.general.caculate;

// Pow(x, n)
public class power {
    public double myPow(double x, int N) {
        if(x==0.0f) return 0.0d;
        double ans = 1.0;
        long n=N;
        if(n<0){
            n=-n;
            x=1/x;
        }
        while(n!=0){
            if((n&1)==1){
                ans*=x;
            }
            x*=x;
            n>>=1; // faster than n >>= 1;
        }
        return ans;
    }
}
