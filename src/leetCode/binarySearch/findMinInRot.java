package leetCode.binarySearch;

// 寻找旋转排序数组中的最小值
public class findMinInRot {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int left = -1,right = nums.length;
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid]>nums[nums.length-1]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return nums[right];
    }
}
