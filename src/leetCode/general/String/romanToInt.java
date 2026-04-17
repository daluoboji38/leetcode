package leetCode.general.String;

import java.util.Map;

public class romanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.ofEntries(
                Map.entry("M", 1000), Map.entry("CM", 900), Map.entry("D", 500),
                Map.entry("CD", 400), Map.entry("C", 100), Map.entry("XC", 90),
                Map.entry("L", 50), Map.entry("XL", 40), Map.entry("X", 10),
                Map.entry("IX", 9), Map.entry("V", 5), Map.entry("IV", 4), Map.entry("I", 1)
        );
        int res =0;
        int index = 0;
        while(index < s.length()){
            if(index<s.length()-1 && (map.get(s.substring(index,index+1)) < map.get(s.substring(index+1,index+2)))){
                res += map.get(s.substring(index,index+2));
                index += 2;
            }else{
                res += map.get(s.substring(index,index+1));
                index += 1;
            }
        }
        return res;
    }
}
