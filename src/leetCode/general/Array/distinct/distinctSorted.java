package leetCode.general.Array.distinct;
// 删除有序数组中的重复项
public class distinctSorted {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i=1; i<nums.length; i++){
            if(nums[i]!= nums[k]){
                nums[++k] = nums[i];
            }
        }
        return k+1;
    }
}
