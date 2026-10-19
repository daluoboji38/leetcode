package leetCode;

import leetCode.SegmentTree.arr.cntSquareSum;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

class Main {
     void main(String[] args) {
         cntSquareSum ex = new cntSquareSum();
        // test ex = new test();


         int res = ex.sumCounts(List.of(1,2,1));
        System.out.println(res);


    }
}
