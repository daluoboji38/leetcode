package leetCode.general.Array.extremum;

// 数位和等于下标的最小下标
public class smallestDigSumIdx {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int x = nums[i];
            while (x != 0&&sum<i) {
                sum += x % 10;
                x /= 10;
            }
            if (x==0&&sum==i) {return i;}
        }
        return -1;
    }
}
