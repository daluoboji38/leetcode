package leetCode;

import leetCode.greedy.TDArray.Recursion.MinPathSumV2;
import leetCode.greedy.TDArray.allPaths2;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        MinPathSumV2 ex = new MinPathSumV2();
        int result = ex.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
        System.out.println(result);


    }
}
