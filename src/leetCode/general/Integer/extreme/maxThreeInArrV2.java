package leetCode.general.Integer.extreme;

public class maxThreeInArrV2 {
        public int maximumProduct(int[] nums) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < max3) {

                } else if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }
                if (num > min2) {

                } else if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }
            int number1 = max1 * max2 * max3;
            int number2 = max1 * min2 * min1;
            if (number1 > number2) {
                return number1;
            } else {
                return number2;
            }

        }
}
