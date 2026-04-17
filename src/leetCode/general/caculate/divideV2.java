package leetCode.general.caculate;

public class divideV2 {
    public int divide(int dividend, int divisor) {
        // range for int −2^31,  2^31 − 1, this judge avoid overflow
        if (dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;

        // XOR operation, return 1 if mismatch
        boolean isNeg=(dividend ^  divisor)<0;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int result =0;


        // Doubling method
        for (int i=31; i>=0; i--) {
            if((a>>i)>=b){
                result+=(1<<i);
                a-=b<<i;
            }
        }
        return isNeg? -result:result;
    }
}
