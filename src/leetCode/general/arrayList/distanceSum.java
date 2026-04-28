package leetCode.general.arrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 等值距离和
public class distanceSum {
    public long[] distance(int[] nums) {
        int n=nums.length;
        var groups=new HashMap<Integer, List<Integer>>();
        for(int i=0;i<n;++i){
            groups.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        var ans=new long[n];
        var s=new long[n+1]; // prefix sum
        for(var a : groups.values()){
            int m=a.size();
            for(int i=0;i<m;++i){
                s[i+1]=s[i]+a.get(i);
            }
            for(int i=0;i<m;++i){
                int target=a.get(i);
                long left=(long)target*i-s[i];
                long right=s[m]-s[i]-(long)target*(m-i);
                ans[target]=left+right;
            }
        }
        return ans;
    }
}
