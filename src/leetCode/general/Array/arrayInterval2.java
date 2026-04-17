package leetCode.general.Array;

public class arrayInterval2 {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -k - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                continue;
            }
            if (i - prev <= k) {
                return false;
            }
            prev = i;
        }
        return true;
    }
}
