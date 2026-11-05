package leetCode;

import leetCode.FenwickTree.dfsTimestamp.weightedTreeShortestPath;
import leetCode.dfs.TDArr.islandDivByK;

import java.util.Arrays;


// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

class Main {
     void main(String[] args) {
         weightedTreeShortestPath ex = new weightedTreeShortestPath();
        // test ex = new test();


        int[] res = ex.treeQueries(3,new int[][]{{1,2,2},{1,3,4}},new int[][]{{2,1},{2,3},{1,1,3,7},{2,2},{2,3}});
        System.out.println(Arrays.toString(res));


    }
}
