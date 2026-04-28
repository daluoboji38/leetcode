package leetCode;

import leetCode.binarySearch.elementRange;
import leetCode.differenceArray.carpool;
import leetCode.general.Array.wordMatching;
import leetCode.general.String.lstPar;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        elementRange ex = new elementRange();
        int[] res=ex.searchRange(new int[]{1},1);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
