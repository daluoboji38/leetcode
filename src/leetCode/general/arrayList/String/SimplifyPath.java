package leetCode.general.arrayList.String;

import java.util.ArrayDeque;
import java.util.Deque;

// 简化路径
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        String[] split = path.split("/+");
        for (int i=1; i<split.length; i++) {
            if (split[i].equals("..") ) {
                if (!deque.isEmpty()){
                    deque.pollLast();
                }
            } else if (!split[i].equals(".")) {
                deque.offerLast(split[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            return "/";
        }
        for (String dir : deque) {
            sb.append("/").append(dir);
        }
        return sb.toString();
    }
}
