package leetCode.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class nineKeyInput {
    public List<String> letterCombinations(String digits) {
        Map<Character, String[]> digitMap = new HashMap<>() {{
            put('2', new String[]{"a", "b", "c"});
            put('3', new String[]{"d", "e", "f"});
            put('4', new String[]{"g", "h", "i"});
            put('5', new String[]{"j", "k", "l"});
            put('6', new String[]{"m", "n", "o"});
            put('7', new String[]{"p", "q", "r", "s"});
            put('8', new String[]{"t", "u", "v"});
            put('9', new String[]{"w", "x", "y", "z"});
        }};
        List<String> res = new ArrayList<>(){{}};
        res.add("");
        for(int i = 0; i < digits.length(); i++){
            char digit = digits.charAt(i);
            String[] next = digitMap.get(digit);
            res = handleNextKey(res, next, new StringBuffer());
        }
        return res;
    }

    private List<String> handleNextKey(List<String> last, String[] next, StringBuffer sb){
        List<String> res = new ArrayList<>();
        for (String s : last) {
            for (String string : next) {
                res.add(sb.append(s).append(string).toString());
            }
        }
        return res;
    }
}