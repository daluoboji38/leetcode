package leetCode.general.Array.sort;

import java.util.Arrays;

// 颜色分类
public class ClassifyColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0, two = n - 1;
        for(int i = 0; i < n; i++){
            switch (nums[i]){
                case 0:
                    zero++;
                    break;
                case 2:
                    two--;
            }
        }
        Arrays.fill(nums, 1);
        Arrays.fill(nums, 0, zero, 0);
        Arrays.fill(nums, two + 1, n, 2);
    }
}
