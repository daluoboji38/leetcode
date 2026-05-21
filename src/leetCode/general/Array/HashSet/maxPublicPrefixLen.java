package leetCode.general.Array.HashSet;

import java.util.HashSet;
import java.util.Set;

// 最长公共前缀的长度
public class maxPublicPrefixLen {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> st = new HashSet<>();
        for(int x : arr1){
            for(;x>0;x/=10){
                st.add(x);
            }
        }
        int mx=0;
        for(int x : arr2){
            while(x>0 && !st.contains(x)){
                x/=10;
            }
            mx=Math.max(mx,x);
        }
        return mx>0?Integer.toString(mx).length():0;
    }
}
