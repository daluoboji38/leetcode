package leetCode.general.binary;

// 不同 XOR 三元组的数目 I
public class UniqueXorTriplets {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        return n<=2?n:1<<(32-Integer.numberOfLeadingZeros(n));
    }
}
