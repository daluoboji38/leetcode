package leetCode.backtrack;

import java.util.*;

// 组合总和
public class conbSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

            path.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],path,res);
            path.removeLast();
        }
    }
}
