package leetCode.general.Array.find;

import java.util.Arrays;

// 找出最大的几近缺失整数
public class biggestEdgeIntV2 {
    public int largestInteger(int[] nums,int k) {
        int n = nums.length;
        int[] cnt=new int[51];
        for(int i=0;i+k<=n;i++){
            boolean[] seen=new boolean[51];
            for(int j=i;j<i+k;j++){
                if(!seen[nums[j]]){
                    seen[nums[j]]=true;
                    cnt[nums[j]]++;
                }
            }
        }
        for(int v=50;v>=0;v--){
            if(cnt[v]==1){
                return v;
            }
        }
        return -1;
    }
}
