package leetCode.Riddle.Arr;

// 排序排列
public class sortByBitwiseAND {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (i != x) {
                ans &= x;
            }
        }
        return Math.max(ans, 0);
    }
}