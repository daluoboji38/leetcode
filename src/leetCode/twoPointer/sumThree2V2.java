package leetCode.twoPointer;

import java.util.Arrays;

// 最接近的三数之和
public class sumThree2V2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 100000;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(best - target)) best = sum;
                if (sum > target) {
                    int right0 = right - 1;
                    while (right0 >= left && nums[right0] == nums[right]) right0--;
                    right = right0;
                } else {
                    int left0 = left + 1;
                    while (left0 <= right && nums[left0] == nums[left]) left0++;
                    left = left0;
                }
            }
        }
        return best;
    }
}
