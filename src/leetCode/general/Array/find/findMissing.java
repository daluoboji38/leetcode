package leetCode.general.Array.find;

import java.util.ArrayList;
import java.util.List;

// 找出缺失的元素
public class findMissing {
    public List<Integer> findMissingElements(int[] nums) {
        int left=100,right=0;
        int[] memo=new int[101];
        for(int num:nums){
            memo[num]++;
            left=Math.min(left,num);
            right=Math.max(right,num);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=left+1;i<right;i++){
            if(memo[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
