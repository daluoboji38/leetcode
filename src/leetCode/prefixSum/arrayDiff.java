package leetCode.prefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 使数组元素全部相等的最少操作次数
public class arrayDiff {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n=nums.length;
        long[] sum=new long[n+1];// prefix sum
        for(int i=0;i<n;i++){
            sum[i+1]=sum[i]+nums[i];
        }

        List<Long> ans=new ArrayList<>(queries.length);
        for(int q:queries){
            int j=lowerBound(nums,q);
            long left=(long)q*j-sum[j];
            long right=sum[n]-sum[j]-(long)q*(n-j);
            ans.add(left+right);
        }
        return ans;
    }


    // binary search
    private int lowerBound(int[] nums,int target){
        int left=-1,right=nums.length;
        while(left+1<right) {
            int mid = (right + left) >>>1 ;// equal to mid = (l + r) / 2 but safer and faster
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
