package leetCode;

import leetCode.backtrack.combSum2;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        combSum2 ex = new combSum2();
        List<List<Integer>> result = ex.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);

        System.out.println("组合总数: " + result.size());

        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
