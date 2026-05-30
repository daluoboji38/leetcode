package leetCode.backtrack.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 全排列
public class premutation {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = Arrays.asList(new Integer[n]);
        boolean[] visited = new boolean[n];

        backtrack(0, nums, ans, path, visited);
        return ans;
    }

    public void backtrack(int i,int[] nums,List<List<Integer>> ans, List<Integer> path, boolean[] visited){
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int j = 0; j < nums.length; j++) {
            if(!visited[j]) {
                path.set(i, nums[j]);
                visited[j] = true;
                backtrack(i + 1, nums, ans, path, visited);
                visited[j] = false;
            }
        }
    }
}
