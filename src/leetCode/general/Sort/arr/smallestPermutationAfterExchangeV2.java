package leetCode.general.Sort.arr;

import java.util.ArrayList;
import java.util.Arrays;

//交换得到字典序最小的数组
public class smallestPermutationAfterExchangeV2 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        Integer[] pos=new Integer[n];
        Arrays.setAll(pos, i->i);
        Arrays.sort(pos, (i,j)->nums[i]-nums[j]);// asc

        ArrayList<Integer> groups=new ArrayList<>();
        int[] belong=new int[n];
        for(int i=0;i<n;i++){
            int p=pos[i];
            if(i==0||nums[p]-nums[pos[i-1]]>limit){
                groups.add(i);
            }
            belong[p]=groups.size()-1;
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int gid=belong[i];
            int curIdx=groups.get(gid);
            ans[i]=nums[pos[curIdx]];
            groups.set(gid,curIdx+1);
        }
        return ans;
    }
}
