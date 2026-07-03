package leetCode.backtrack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 组合
public class Combination {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new Integer[k]);
        return ans;
    }

    private void backtrack(int start, int end, int idx, Integer[] path) {
        if(idx == 0) {
            ans.add(List.of(path));
            return;
        }
        for(int i = start; i <= end-idx+1; i++) {
            path[idx-1] = i;
            backtrack(i + 1, end, idx - 1, path);
        }
    }
}
