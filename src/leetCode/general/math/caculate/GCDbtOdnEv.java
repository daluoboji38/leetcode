package leetCode.general.math.caculate;


// 奇数和与偶数和的最大公约数
public class GCDbtOdnEv {
    public int gcdOfOddEvenSums(int n) {
        int evens = (1+n)*n;
        int odds=evens-n;
        return gcd(evens,odds);
    }
    private int gcd(int a,int b){
        while(a!=0){
            int tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }
}
