package leetCode.general.Array.find;

import java.util.ArrayList;
import java.util.List;

// 找出数组排序后的目标下标
public class sortArrIdxV2 {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0;
        int equal=0;
        for(int x:nums){
            if(x<target){less++;}
            else if(x==target){equal++;}
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<equal;i++){
            res.add(less+i);
        }
        return  res;
    }
}
