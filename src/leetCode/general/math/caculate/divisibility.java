package leetCode.general.math.caculate;

// 判断整除性
public class divisibility {
    public boolean checkDivisibility(int n) {
        int sum=0,product=1;
        int tmp=n;
        while(tmp>0){
            int digit=tmp%10;
            sum+=digit;
            product*=digit;
            tmp/=10;
        }
        return n%(sum+product)==0;
    }
}
