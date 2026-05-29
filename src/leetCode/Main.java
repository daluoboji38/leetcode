package leetCode;

import leetCode.backtrack.Array.premutation;
import leetCode.general.String.specialLetter2;
import leetCode.greedy.Array.jumpGame4;
import leetCode.greedy.String.regexMatch2;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        premutation ex = new premutation();
        List<List<Integer>> result = ex.permute(new int[]{1,2,3});
        System.out.println(result);


    }
}
