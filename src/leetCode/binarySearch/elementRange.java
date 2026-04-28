package leetCode.binarySearch;

// 在排序数组中查找元素的第一个和最后一个位置
public class elementRange {
    public int[] searchRange(int[] nums, int target) {
        int start=lower_bound(nums,target);
        if(start==nums.length || nums[start]!=target){
            return new int[]{-1,-1};
        }
        int end=lower_bound(nums,target+1)-1;
        return new int[]{start,end};
    }

    private int lower_bound(int[] nums,int target){
        int left =-1,right=nums.length;
        while(left+1<right){
            int mid=(left+right)>>>1;
            if(nums[mid]>=target){
                right = mid;
            }else{
                left=mid;
            }
        }
        return right;
    }
}
