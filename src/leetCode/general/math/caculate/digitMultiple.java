package leetCode.general.math.caculate;

// 最小可整除数位乘积 I
public class digitMultiple {
    public int smallestNumber(int n,int t){
        for(int i=n;;i++){
            int prod=1;
            for(int x=i;x>0;x/=10){
                prod*=x%10;
            }
            if(prod%t==0)return i;
        }
    }
}
