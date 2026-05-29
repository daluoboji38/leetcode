package leetCode.backtrack.Array;

import java.util.ArrayList;
import java.util.List;

// 全排列
public class premutation {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        backtrack(list, path);
        return res;
    }

    public void backtrack(List<Integer> list, List<Integer> path){
        if (list.isEmpty()) {
            res.add(path);
            return;
        }

        for(int i = 0; i < list.size(); i++) {
            List<Integer> temp = list;
            path.add(list.get(i));
            temp.remove(i);
            backtrack(temp, path);
            path.removeLast();
        }
    }
}
