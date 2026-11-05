package leetCode.general.Array.extreme;

import java.util.Arrays;

// 最小操作次数使数组元素相等 II
// What's the minimum number of operations to make all elements in `nums` equal?
// It is optimal to convert all numbers to the median of `nums`.
public class minOperationToIdentical2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        int ans=0;
        for(int x:nums){
            ans+=Math.abs(x-median);
        }
        return ans;
    }
}
