package leetCode.stack.String;

import java.util.*;

// 花括号展开 II
public class braceExpansion2 {
    public List<String> braceExpansionII(String expression) {
        List<Set<String>[]> stack = new ArrayList<>();
        Set<String> res = new HashSet<>();
        Set<String> cur = new HashSet<>();
        cur.add("");
        for(char ch : expression.toCharArray()) {
            if(Character.isLowerCase(ch)){
                Set<String> newSet = new HashSet<>();
                for(String s : cur){
                    newSet.add(s+ch);
                }
                cur = newSet;
            }else if(ch==','){
                res.addAll(cur);
                cur.clear();
                cur.add("");
            }else if(ch=='{'){
                stack.add(new Set[]{res,cur});
                res = new HashSet<>();
                cur = new HashSet<>();
                cur.add("");
            }else{
                res.addAll(cur);
                Set<String> subRes=res;
                Set<String>[] p=stack.removeLast();
                res=p[0];
                cur=p[1];
                Set<String> newSet=new HashSet<>();
                for(String s:cur){
                    for(String t:subRes){
                        newSet.add(s+t);
                    }
                }
                cur=newSet;
            }
        }
        res.addAll(cur);
        List<String> ans=new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }
}
