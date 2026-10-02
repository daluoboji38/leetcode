package leetCode.general.hashMap;

import java.util.HashMap;
import java.util.List;

// 替换字符串中的括号内容
public class replaceBracket {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mp = HashMap.newHashMap(knowledge.size());
        for (List<String> kv : knowledge) {
            mp.put(kv.get(0), kv.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int n = s.length();
        int left=-1;
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c=='('){
                left=i;
            }else if(c==')'){
                String t=s.substring(left+1,i);
                t=mp.getOrDefault(t,"?");
                ans.append(t);
                left=-1;
            }else if(left<0){
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
