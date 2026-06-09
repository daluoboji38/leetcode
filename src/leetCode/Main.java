package leetCode;

import leetCode.general.TDArray.spiralMatrix;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        spiralMatrix ex = new spiralMatrix();
        List<Integer> result = ex.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(result);


    }
}
