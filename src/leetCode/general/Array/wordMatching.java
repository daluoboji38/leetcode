package leetCode.general.Array;

import java.util.ArrayList;
import java.util.List;

// 距离字典两次编辑以内的单词
public class wordMatching {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String q:queries){
            for(String d:dictionary){
                int cnt=0;
                for(int i=0;i<d.length() && cnt<=2;i++){
                    if(d.charAt(i)!=q.charAt(i)){
                        cnt++;
                    }
                }
                if(cnt<=2){
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}
