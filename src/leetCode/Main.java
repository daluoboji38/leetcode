package leetCode;

import leetCode.DAG.TopologicalSort.MaxMinPath;
import leetCode.DAG.TopologicalSort.MaxMinPathV2;
import leetCode.binarySearch.Array.findTargetInRot2;
import leetCode.general.Array.distinct.distinctSorted2;
import leetCode.general.Array.distinct.rmDuplicate;
import leetCode.greedy.Array.extremum.MaxScorePath;

import java.util.Arrays;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

public class Main {
    public void main(String[] args) {
        MaxScorePath ex = new MaxScorePath();

        int[] result = ex.pathsWithMaxScore(Arrays.asList(new String[]{"EX","XS"}));
        System.out.println(Arrays.toString(result));


    }
}
