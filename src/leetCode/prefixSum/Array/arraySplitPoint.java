package leetCode.prefixSum.Array;

import java.util.ArrayList;
// 使数组元素等于零
public class arraySplitPoint {
    public int countValidSelections(int[] nums) {
        ArrayList<Integer> start = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) start.add(i);
            sum += nums[i];
        }
        int m = start.size();
        int leftSum = 0;
        int res = 0;
        for(int j=0;sum-2*leftSum>=-1 && j<nums.length;j++){
            leftSum+=nums[j];
            if(sum==2*leftSum && start.contains(j)) res += 2;
            else if(Math.abs(sum-2*leftSum)==1 && start.contains(j)) res++;
        }
        return res;
    }
}
