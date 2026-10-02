package leetCode.general.Array.find;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 找出最大的几近缺失整数
public class biggestEdgeInt {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        if(k==n){
            return Arrays.stream(nums).max().getAsInt();
        }
        if(k==1){
            Map<Integer,Integer> cnt=new HashMap<>();
            for(int x:nums){
                cnt.merge(x,1,Integer::sum);
            }
            int ans=-1;
            for(var e:cnt.entrySet()){
                if(e.getValue()==1)ans=Math.max(ans,e.getKey());
            }
            return ans;
        }
        return Math.max(f(nums,1,n,nums[0]),f(nums,0,n-1,nums[n-1]));
    }

    private int f(int[] nums, int begin,int end,int x){
        for(int i=begin;i<end;i++){
            if(nums[i]==x){
                return -1;
            }
        }
        return x;
    }
}
