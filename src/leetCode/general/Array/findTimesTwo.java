package leetCode.general.Array;

import java.util.Arrays;

// 将找到的值乘以2
public class findTimesTwo {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int res=original;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==res) {
                res *= 2;
            }else if(nums[i]>res){
                break;
            }
        }
        return res;
    }
}
