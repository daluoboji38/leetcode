package leetCode.general.Array;

//替换为数位和以后的最小元素
public class minDigitSum {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int j : nums) {
            int sum = 0;
            while (j != 0) {
                sum += j % 10;
                j /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
