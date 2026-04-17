package leetCode.general.String;

import java.util.HashMap;
import java.util.Map;

// 罗马数字转整数
public class romanToIntV2 {
    Map<Character, Integer> symbolValue = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};// initialize the symbolValue map

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = symbolValue.get(s.charAt(i));
            if(i<s.length()-1 && value<symbolValue.get(s.charAt(i+1))){
                result -= value;
            }else{
                result += value;
            }
        }
        return result;
    }
}
