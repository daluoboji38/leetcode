package leetCode.backtrack;

import java.util.*;

// 组合总和 II
public class combSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len=candidates.length;
        List<List<Integer>> res=new ArrayList<>();
        if(len==0) return res;

        Arrays.sort(candidates);
        Deque<Integer> path=new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }


    private void dfs(int[] candidates,int begin, int len,int target,Deque<Integer> path,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=begin;i<len;i++){
            if(target-candidates[i]<0){
                break;
            }
            if(i>begin && candidates[i]==candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i+1, len, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
