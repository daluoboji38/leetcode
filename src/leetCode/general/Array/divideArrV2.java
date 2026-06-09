package leetCode.general.Array;

import java.util.Arrays;

public class divideArrV2 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans,pivot);
        int left =0,right=n-1;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot) ans[left++]=nums[i];
            else if(nums[i]>pivot) ans[right--]=nums[i];
        }
        reverse(ans,right+1,n-1);
        return ans;
    }

    private void reverse(int[] nums,int left,int right){
        while (left<right){
            int temp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=temp;
        }
    }
}
