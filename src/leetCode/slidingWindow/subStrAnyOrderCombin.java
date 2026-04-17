package leetCode.slidingWindow;

// 串联所有单词的子串

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subStrAnyOrderCombin {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen=words[0].length();
        int windowLen=wordLen * words.length;

        Map<String,Integer> targetCnt=new HashMap<>();
        for(String w:words){
            targetCnt.merge(w,1,Integer::sum);
        }

        List<Integer> ans=new ArrayList<>();
        // enum the left endpoint of the 1st window and create workLen times sliding windows with different starting points
        for(int start=0;start<wordLen;start++){
            Map<String,Integer> cnt=new HashMap<>();
            int overload=0; // counting excessive words
            for(int right =start+wordLen;right<=s.length();right+=wordLen){
                String inword=s.substring(right-wordLen,right);
                if(cnt.getOrDefault(inword,0).equals(targetCnt.getOrDefault(inword,0))){
                    overload++;
                }
                cnt.merge(inword,1,Integer::sum);
                int left=right-windowLen;
                if(left <0) continue;

                if(overload==0) ans.add(left);

                // the leftmost word exit the window, prepare for next iteration
                String outWord=s.substring(left,left+wordLen);
                cnt.merge(outWord,-1,Integer::sum);
                if(cnt.get(outWord).equals(targetCnt.getOrDefault(outWord,0))){
                    overload--;
                }
            }
        }
        return ans;
    }
}
