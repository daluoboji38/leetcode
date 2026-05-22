package leetCode.greedy.Array;

// 检查数组是否经排序和轮转得到
 public class isRotArr {
    public boolean check(int[] nums) {
        boolean flag=(nums[0]<nums[nums.length-1]);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(flag){
                    return false;
                }
                flag=true;
            }
        }
        return true;
    }
}
