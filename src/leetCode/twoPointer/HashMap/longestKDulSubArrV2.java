package leetCode.twoPointer.HashMap;

// 最多 K 个重复元素的最长子数组

import java.util.HashMap;
import java.util.Map;

public class longestKDulSubArrV2 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int right=0,left=0;right<nums.length;right++){
            Integer v=map.merge(nums[right],1,Integer::sum);
            while(v>k){
                map.merge(nums[left],-1,Integer::sum);
                if(nums[left]==nums[right]){v--;}
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
