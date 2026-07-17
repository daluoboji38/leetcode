package leetCode;

import leetCode.BinaryLifting_TwoPointer.Arr.pathExistQry2;
import leetCode.MultipleInclusionExclusion.qryGCDAfterSort;
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
        qryGCDAfterSort ex = new qryGCDAfterSort();

        int[] result = ex.gcdValues(new int[]{4,4,2,1}, new long[]{5,3,1,0});
        System.out.println(Arrays.toString(result));


    }
}
