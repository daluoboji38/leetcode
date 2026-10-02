package leetCode.general.hashSet.Arr;

import java.util.HashSet;
import java.util.Set;

// 大于等于顺序前缀和的最小缺失整数
public class lastContinuesSum {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length && nums[i]==nums[i-1]+1;i++){
            sum+=nums[i];
        }

        Set<Integer> set = new HashSet<>();
        for(int num:nums)set.add(num);
        while(set.contains(sum))sum++;
        return sum;
    }
}
