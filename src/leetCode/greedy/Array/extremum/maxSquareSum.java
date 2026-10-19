package leetCode.greedy.Array.extremum;

import java.util.Arrays;

// 最大交替平方和
public class maxSquareSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        int m=n/2;
        long ans=0;
        for(int i=0;i<m;i++)ans-=nums[i];
        for(int i=m;i<n;i++)ans+=nums[i];
        return ans;

    }
}
