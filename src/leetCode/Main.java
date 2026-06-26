package leetCode;

import leetCode.general.Array.cnt.MajeritySubArrCntV2;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        MajeritySubArrCntV2 ex = new MajeritySubArrCntV2();
        // int result = ex.countMajoritySubarrays(new int[]{874,874,796,874,194,468,329,874,874,874,874,874,874,637,809,874,874,874,94,874},874);
        int result = ex.countMajoritySubarrays(new int[]{1,2,2,3},2);

        System.out.println(result);


    }
}
