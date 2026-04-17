package leetCode.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 四数之和
public class sumFour {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < n - 3; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            long target2 = target - nums[first];
            for (int second = first + 1; second < n - 2; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                int fourth = n - 1;
                long target3 = target2 - nums[second];
                for (int third = second + 1; third < n - 1; third++) {
                    if (third > second + 1 && nums[third] == nums[third - 1]) continue;
                    while (fourth > third && nums[third] + nums[fourth] > target3) {
                        fourth--;
                    }
                    if (fourth == third) break;
                    if (nums[third] + nums[fourth] == target3) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                    }
                }
            }
        }
        return res;
    }
}
