package leetCode.general.arrayList.String;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPathV2 {
    public String simplifyPath(String path) {
        List<String> stk = new ArrayList<>();
        for(String s : path.split("/")){
            if(!s.isEmpty() && !s.equals(".")){
                if(!s.equals("..")){
                    stk.add(s);
                }else if(!stk.isEmpty()){
                    stk.removeLast();
                }
            }
        }
        return "/"+String.join("/", stk);
    }
}
