package leetCode.backtrack;

import java.util.ArrayList;
import java.util.List;

// replace StringBuffer,HashMap with StringBuilder, String[]

public class nineKeyInputV3 {
    List<String> combinations = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return combinations;
        }
        String[] phoneMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(phoneMap,digits,0);
        return combinations;
    }
    public void backtrack(String[] phoneMap,String digits,int index){
        if (index == digits.length()) {
            combinations.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(phoneMap,digits,index+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
