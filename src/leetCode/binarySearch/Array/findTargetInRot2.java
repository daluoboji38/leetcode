package leetCode.binarySearch.Array;

// 搜索旋转排序数组 II
public class findTargetInRot2 {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) return false;
        int left = 0,right = nums.length-1;
        int mid;
        while(left<=right){
            mid = (left+right)>>>1;
            if(nums[mid]==target) return true;
            if(nums[left]==nums[mid]) {
                left++;
            }else if(nums[left]<nums[mid]){
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return false;
    }
}
