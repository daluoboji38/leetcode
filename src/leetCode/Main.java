package leetCode;

import leetCode.general.Array.extreme.sortMinOperation2;

import java.util.List;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

class Main {
     void main(String[] args) {
         sortMinOperation2 ex = new sortMinOperation2();
        // test ex = new test();


         int res = ex.minOperations(new int[]{1,0,2});
        System.out.println(res);


    }
}
