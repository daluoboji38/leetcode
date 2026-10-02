package leetCode.twoPointer.HashMap;

import java.util.HashMap;
import java.util.Map;

// 最多 K 个重复元素的最长子数组
public class longestKDulSubArr {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0, right = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == k) {
                    while (nums[left] != num) {
                        map.compute(nums[left++],(key, value) -> --value);
                    }
                    left++;
                } else {
                    map.compute(num, (key, value) -> ++value);
                }
            } else {
                map.put(num, 1);
            }
            ans = Math.max(ans, ++right - left);
        }
        return ans;
    }
}
