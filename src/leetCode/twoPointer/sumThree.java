package leetCode.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和
// two-pointer: As the first element increase, the second decrease
public class sumThree {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int first =0;first<n;first++){
            if(first>0 && nums[first]==nums[first-1]) continue;
            int third = n-1;
            int target = -nums[first];
            for(int second=first+1;second<n;second++){
                if(second>first+1 && nums[second]==nums[second-1]) continue;
                while(second<third && nums[second]+nums[third]>target){
                    third--;
                }
                if(second==third) break;
                if(nums[second]+nums[third]==target){
                    res.add(Arrays.asList(nums[first],nums[second],nums[third]));
        }
    }
}
        return res;
    }
}
