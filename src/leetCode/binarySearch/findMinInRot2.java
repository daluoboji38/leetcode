package leetCode.binarySearch;

public class findMinInRot2 {
    public int findMin(int[] nums) {
        int left = -1,right = nums.length-1;
        while(left+1<right){
            int mid = (left+right)>>>1;
            if(nums[mid] == nums[right]){
                right--;
            }else if(nums[mid]>nums[right]){
                left = mid;
            }else {
                right = mid;
            }
        }
        return nums[right];
    }
}