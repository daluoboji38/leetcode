package leetCode.BitOperation.Iteration;

// 找出第 K 个字符 II
public class KthCinBitExpandStr {
    public char kthCharacter(long k, int[] operations) {
        k--;
        int inc=0;
        for(int i=63-Long.numberOfLeadingZeros(k);i>=0;i--){
            inc+=k>>i&operations[i];
        }
        return(char)('a'+inc%26);
    }
}
