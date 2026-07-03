package leetCode.general.Enumerate.Array;

import java.util.ArrayList;
import java.util.List;

// 子集
public class PowerSet {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            one(n,i,0,0,nums,new Integer[i]);
        }
        return ans;
    }

    private void one(int n,int k,int cur,int depth,int[] nums,Integer[] path){
        if(n-cur<k-depth)return;
        if(depth==k){
            ans.add(List.of(path));
            return;
        }
        path[depth] = nums[cur];
        one(n,k,cur+1,depth+1,nums,path);
        one(n,k,cur+1,depth,nums,path);
    }
}
