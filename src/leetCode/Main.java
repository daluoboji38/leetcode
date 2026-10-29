package leetCode;

import leetCode.dfs.TDArr.islandDivByK;


// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

class Main {
     void main(String[] args) {
         islandDivByK ex = new islandDivByK();
        // test ex = new test();


        int res = ex.countIslands(new int[][]{{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}},5);
        System.out.println(res);


    }
}
