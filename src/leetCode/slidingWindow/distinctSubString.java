package leetCode.slidingWindow;

import java.util.HashMap;
// 无重复字符的最长子串
// Longest Substring Without Repeating Characters
public class distinctSubString {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max =0, left =0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
