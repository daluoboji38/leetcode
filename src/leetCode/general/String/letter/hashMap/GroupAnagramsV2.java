package leetCode.general.String.letter.hashMap;


import java.util.*;

public class GroupAnagramsV2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            List<List<String>> list = null;

            private void init() {
                if(list != null) return;
                Map<String, List<String>> map = new HashMap<>();
                for (String str : strs) {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    String key = new String(chars);
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
                }
                list = new ArrayList<>(map.values());
            }

            @Override
            public List<String> get(int index) {
                init();
                return list.get(index);
            }

            @Override
            public int size() {
                init();
                return list.size();
            }
        };
    }
}
