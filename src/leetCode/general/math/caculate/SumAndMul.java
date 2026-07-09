package leetCode.general.math.caculate;

// 连接非零数字并乘以其数字和 I
public class SumAndMul {
    public long sumAndMultiply(int n) {
        int x=0,sum=0,add,place=1;
        while(n>0){
            add=n%10;
            n = n / 10;
            if(add!=0) {
                x += add*place;
                place*=10;
                sum += add;
            }
        }
        return (long) sum *x;
    }
}
