package leetCode.general.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 数组序号转换
public class arrayRank {
    public int[] arrayRankTransform(int[] arr) {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length,idx=0;
        for(int i:clone){
            if(!map.containsKey(i)){
                map.put(i, ++idx);
            }
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
