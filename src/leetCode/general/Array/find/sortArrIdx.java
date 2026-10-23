package leetCode.general.Array.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 找出数组排序后的目标下标
public class sortArrIdx {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                while (i < nums.length && nums[i] == target) {
                    res.add(i);
                    i++;
                }
                return res;
            }
        }
        return res;
    }
}
