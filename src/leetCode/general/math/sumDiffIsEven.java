package leetCode.general.math;

// 统计元素和差值为偶数的分区方案


import java.util.Arrays;

public class sumDiffIsEven {
    public int countPartitions(int[] nums){
        int s = Arrays.stream(nums).sum();
        return s%2==0? nums.length -1 : 0;
    }
}
