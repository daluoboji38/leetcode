package leetCode;

import leetCode.backtrack.combSum2;
import leetCode.general.TDArray.circRotMat;
import leetCode.wightedSegTree.maxJump;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        maxJump ex = new maxJump();
        int result = ex.maximumJumps(new int[]{1,3,6,4,1,2},2);
        System.out.println(result);


    }
}
