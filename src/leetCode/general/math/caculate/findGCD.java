package leetCode.general.math.caculate;

// 找出数组的最大公约数
public class findGCD {
    public int findGCD(int[] nums) {

        int maxNum = nums[0];
        int minNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }
        return gcd(maxNum, minNum);
    }

    private int gcd(int a,int b){
        while(a!=0){
            int tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }
}
