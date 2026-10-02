package leetCode.slidingWindow.extremum;

public class deductXToZero {
    public int minOperations(int[] nums, int x) {
        int target=-x;
        for(int num:nums){target+=num;}
        if(target<0)return -1;
        int n=nums.length;
        int ans=-1;
        int sum=0;
        int left=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>target){
                sum-=nums[left++];
            }
            if(sum==target){ans=Math.max(ans,right-left+1);}
        }
        return ans<0?-1:n-ans;
    }
}
