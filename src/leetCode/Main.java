package leetCode;

import leetCode.prefixSum.Array.SumAndMul2;

import java.util.Arrays;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

public class Main {
    public void main(String[] args) {
        SumAndMul2 ex = new SumAndMul2();

        int[] result = ex.sumAndMultiply("2711785625", new int[][]{{0, 9}});
        System.out.println(Arrays.toString(result));


    }
}
