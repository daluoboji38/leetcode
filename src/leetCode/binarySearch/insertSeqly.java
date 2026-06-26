package leetCode.binarySearch;

// 搜索插入位置
// open interval
public class insertSeqly {
    public int searchInsert(int[] nums, int target) {
        return lower_bound(nums,target);
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
