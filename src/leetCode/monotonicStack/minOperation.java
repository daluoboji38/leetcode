package leetCode.monotonicStack;

import java.util.ArrayList;
import java.util.List;
// 将所有元素变为0的最少操作次数
// monotonic increasing stack
public class minOperation {
    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;
        for (int a : nums){
            while (!s.isEmpty() && s.get(s.size()-1) > a){
                s.remove(s.size()-1);
            }
            if(a==0) continue;
            if(s.isEmpty() || s.get(s.size()-1)<a){
                res++;
                s.add(a);
            }
        }
        return res;
    }
}
