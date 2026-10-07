package leetCode;

import leetCode.SegmentTree.arr.XInArr2;
import leetCode.general.Array.extremum.extremDelete;
import leetCode.general.String.validation.validParenthesesWithAsterisk;
import leetCode.general.location.CircleRectangleOverlap;
import leetCode.greedy.String.statistics.greaterPalindromicPermutation;
import leetCode.greedy.String.statistics.greaterPermutation;
import leetCode.recursion.String.ReverseParentheses;
import leetCode.tree.BinaryTree.TreeNode;
import leetCode.tree.BinaryTree.cnt.subTreeAvgV2;

// % 是求余运算符，而 / 才是求商运算符

// Integer.MIN_VALUE: -2147483648
// Integer.MAX_VALUE: 2,147,483,647

// ASCII A-Z: 65-90
// ASCII a-z: 97-122
// ASCII 0-9: 48-57

class Main {
     void main(String[] args) {
         validParenthesesWithAsterisk ex = new validParenthesesWithAsterisk();
        // test ex = new test();


        boolean res = ex.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        System.out.println(res);


    }
}
