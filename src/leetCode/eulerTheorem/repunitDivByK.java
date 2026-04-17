package leetCode.eulerTheorem;
// 可被K整除的最小整数
public class repunitDivByK {
    public int smallestRepunitDivByK(int k) {
        // because the unit digit of a repunit is 1, so it can't be divided by 2 or 5, and a solution is guaranteed in all other cases
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int m=phi(k*9);
// i must be a divisor of phi(n)
        int i=1;
        for(;i*i<=m;i++){
            if(m%i==0 && pow(10,i,k*9)==1) return i;
        }
        for(i--;;i--){
            if(m%i==0 && pow(10,m/i,k*9)==1) return m/i;
        }
    }
// calculate Euler's Totient Function, the number of positive integers less than n that are relatively prime to n.
    private int phi(int n) {
        int res = n;
        for(int i = 2; i*i <= n; i++) {
            if(n % i == 0) {
                res =res / i * (i - 1);
                while(n % i == 0) n /= i;
            }
        }
        if(n > 1) res = res / n * (n - 1);
        return res;
    }

    // return (x^n) % mod by using fast exponentiation algorithm
    private long pow(long x, int n, long mod){
        long res = 1;
        for(; n > 0; n >>= 1){
            if(n % 2 == 1) res = (res * x) % mod;
            x = (x * x) % mod;
        }
        return res;
    }
}
