package leetCode;

import leetCode.DAG.TopologicalSort.MaxMinPath;
import leetCode.DAG.TopologicalSort.MaxMinPathV2;
import leetCode.binarySearch.Array.findTargetInRot2;
import leetCode.general.Array.distinct.distinctSorted2;
import leetCode.general.Array.distinct.rmDuplicate;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122

public class Main {
    public void main(String[] args) {
        MaxMinPathV2 ex = new MaxMinPathV2();

        int result = ex.findMaxPathScore(new int[][]{{0,1,5},{1,5,10},{0,2,3},{2,5,4},{3,4,6},{4,5,8}},new boolean[]{true,true,true,true,true,true},10);
        System.out.println(result);


    }
}
