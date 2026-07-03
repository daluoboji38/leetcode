package leetCode.general.Array.distinct;

// 删除有序数组中的重复项 II
public class distinctSorted2 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i=1; i<nums.length-1; i++){
            if(nums[k-1]!=nums[i+1]){
                nums[++k] = nums[i+1];
            }
        }
        return k+1;
    }
}
// 1,1,1,2,2,3