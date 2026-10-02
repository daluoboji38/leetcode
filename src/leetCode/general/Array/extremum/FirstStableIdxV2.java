package leetCode.general.Array.extremum;

// 最小稳定下标 II
public class FirstStableIdxV2 {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] sufMin=new int[n];
        int curMin = nums[n - 1];
        for(int i=n-1;i>=0;i--){
            curMin=Math.min(nums[i],curMin);
            sufMin[i]=curMin;
        }

        int preMax=0;
        for(int i=0;i<n;i++){
            preMax=Math.max(nums[i],preMax);
            if(preMax-sufMin[i]<=k)return i;
        }

        return -1;
    }
}
