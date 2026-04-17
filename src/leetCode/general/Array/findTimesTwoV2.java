package leetCode.general.Array;

public class findTimesTwoV2 {
    public int findFinalValue(int[] nums, int original) {
        int mask = 0;
        for (int num : nums) {
            int k = num/original;
            if(num % original == 0 && (k &(k-1))==0){ // if num is a power of 2: only one bit is set
                mask |= k;
            }
        }
        mask = ~mask; // invert the mask
        return original * (mask & -mask); // multiply original by the rightmost set bit of the mask
    }
}
