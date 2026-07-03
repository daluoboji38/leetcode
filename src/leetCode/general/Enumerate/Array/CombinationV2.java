package leetCode.general.Enumerate.Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationV2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        one(n,k,1,0,new Integer[k]);
        return ans;
    }

    private void one(int n, int k,int cur,int depth,Integer[] path){
        if(n-cur+1<k-depth)return;
        if(depth==k){
            ans.add(List.of(path));
            return;
        }
        path[depth] = cur;
        one(n,k,cur+1,depth+1,path);
        one(n,k,cur+1,depth,path);
    }
}