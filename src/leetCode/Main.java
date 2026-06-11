package leetCode;

import leetCode.ST.MaxSubArrSum2;

// % 是求余运算符，而 / 才是求商运算符
public class Main {
    public void main(String[] args) {
        MaxSubArrSum2 ex = new MaxSubArrSum2();
        long result = ex.maxTotalValue(new int[]{4,2,5,1}, 3);
        System.out.println(result);


    }
}
