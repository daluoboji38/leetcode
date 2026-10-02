package leetCode.general.Sort.arr;

import java.util.Arrays;

//交换得到字典序最小的数组
public class smallestPermutationAfterExchange {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        Integer[] pos=new Integer[n];
        Arrays.setAll(pos, i->i);
        Arrays.sort(pos, (i,j)->nums[i]-nums[j]);// asc

        int[] ans=new int[n];
        int start=0;
        for(int i=0;i<n;i++){
            if(i==n-1||nums[pos[i+1]]-nums[pos[i]]>limit){
                Integer[] subPos=Arrays.copyOfRange(pos,start,i+1);
                Arrays.sort(subPos);
                for(int j=0;j<subPos.length;j++){
                    ans[subPos[j]]=nums[pos[start+j]];
                }
                start=i+1;
            }
        }
        return ans;
    }
}
