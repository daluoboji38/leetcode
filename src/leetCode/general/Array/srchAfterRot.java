package leetCode.general.Array;

// 搜索旋转排序数组
public class srchAfterRot {
    public int search(int[] nums, int target) {
        int n = nums.length,pre=nums[0];
        if(nums[0]==target){return 0;}
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1] && nums[i-1]<target){
                return -1;
            }else if(nums[i]==target){return i;}
        }
        return -1;
    }
}
