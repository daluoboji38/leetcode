package leetCode.general.Array;

import java.util.LinkedList;
import java.util.Queue;

// 根据给定数字划分数组
public class divideArr {
    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> before=new LinkedList<>();
        Queue<Integer> after=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot) before.add(nums[i]);
            else if(nums[i]>pivot) after.add(nums[i]);
            else cnt++;
        }
        int i=0;
        while (!before.isEmpty()){
            nums[i++]=before.poll();
        }
        while (cnt-->0){
            nums[i++]=pivot;
        }
        while (!after.isEmpty()){
            nums[i++]=after.poll();
        }
        return nums;
    }
}
