package leetCode;

import leetCode.backtrack.Array.premutation;
import leetCode.backtrack.Array.premutationDup;
import leetCode.general.String.specialLetter2;
import leetCode.greedy.Array.jumpGame4;
import leetCode.greedy.String.regexMatch2;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        premutationDup ex = new premutationDup();
        List<List<Integer>> result = ex.permuteUnique(new int[]{1,1,2});
        System.out.println(result);


    }
}
