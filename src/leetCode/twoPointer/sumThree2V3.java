package leetCode.twoPointer;

import java.util.Arrays;

// 最接近的三数之和
public class sumThree2V3 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            int min = nums[i] + nums[left] + nums[left + 1];
            int max = nums[i] + nums[right - 1] + nums[right];
            if (min >= target) {
                if (Math.abs(min - target) < Math.abs(res - target)) {
                    res = min;
                }
                continue;
            }
            if (max <= target) {
                if (Math.abs(max - target) < Math.abs(res - target)) {
                    res = max;
                }
                continue;
            }
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                if (sum < target) {
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
            while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
}
