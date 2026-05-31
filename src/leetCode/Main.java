package leetCode;

import leetCode.backtrack.Array.premutation;
import leetCode.backtrack.Array.premutationDup;
import leetCode.general.Array.putQuery;
import leetCode.general.String.specialLetter2;
import leetCode.greedy.String.regexMatch2;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        putQuery ex = new putQuery();
        List<Boolean> result = ex.getResults(new int[][]{{1,6},{1,11},{1,2},{1,22},{1,28},{1,20},{2,30,14}});
        System.out.println(result);


    }
}
