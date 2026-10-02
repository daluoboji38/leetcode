package leetCode.recursion.String;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// 花括号展开 II
public class braceExpansion2V2 {
    int i=0;
    public List<String> braceExpansionII(String expression) {
        TreeSet<String> res = parse(expression);
        return new ArrayList<>(res);
    }

    TreeSet<String> parse(String s){
        TreeSet<String> cur =new TreeSet<>();
        cur.add("");
        while(i<s.length()){
            char c = s.charAt(i);
            if(c=='{'){
                i++;
                TreeSet<String> inner=parse(s);
                cur = combine(cur,inner);
            }else if(c=='}'){
                i++;
                return cur;
            }else if(c==','){
                i++;
                TreeSet<String> rest = parse(s);
                cur.addAll(rest);
                return cur;
            }else{
                i++;
                TreeSet<String> single = new TreeSet<>();
                single.add(String.valueOf(c));
                cur = combine(cur,single);
            }
        }
        return cur;
    }

    TreeSet<String> combine(TreeSet<String> a,TreeSet<String> b){
        TreeSet<String> res = new TreeSet<>();
        for(String x : a){
            for(String y : b){
                res.add(x+y);
            }
        }
        return res;
    }
}
