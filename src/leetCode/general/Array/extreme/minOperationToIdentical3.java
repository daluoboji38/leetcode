package leetCode.general.Array.extreme;

//最小操作次数使数组元素相等

public class minOperationToIdentical3 {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int num:nums){
            sum=sum+num;
            max = Math.max(max,num);
        }
        return max*n-sum;
    }
}
