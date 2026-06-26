package leetCode.general.math;
// 仅含置位位的最小整数（置位位指二进制表示中值为1的位）
public class setBitOnly {
    public int smallestNumber(int n) {
        int base=0;
        while (n > 0) {
            n /= 2;
            base++;
        }
        int res=0;
        for(int i=0;i<base;i++){
            res += (int)Math.pow(2,i);
        }
        return res;
    }
}
