package leetCode.general.String.letter.hashMap;

import java.util.*;

// 字母异位词分组
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] sortedS=s.toCharArray();
            Arrays.sort(sortedS);
            map.computeIfAbsent(new String(sortedS),_->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
