package leetCode;

import leetCode.dynamicProgramming.stockOperation3;
import leetCode.general.Array.XORAfterRangeMultiQry;
import leetCode.general.Array.appleBox;
import leetCode.general.String.binarySub;
import leetCode.general.caculate.divide;
import leetCode.prefixSum.biggestRhombusSum;
import leetCode.slidingWindow.subStrAnyOrderCombin;

import java.util.Arrays;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        XORAfterRangeMultiQry ex = new XORAfterRangeMultiQry();
        System.out.println(ex.xorAfterQueries(new int[]{1,1,1},new int[][]{{0,2,1,4}}));
    }
}
