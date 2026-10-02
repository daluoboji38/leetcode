package leetCode.BitOperation.Arr;

// 按位异或非零的最长子序列
public class longestSubSeqAfterXOR {
    public int longestSubsequence(int[] nums) {
        boolean hasNonZero = false;
        int xor=0;
        for(int x:nums){
            hasNonZero=hasNonZero || x!=0;
            xor ^=x;
        }
        if(!hasNonZero){return 0;}
        int ans=nums.length;
        if(xor==0){ans--;}
        return ans;
    }
}
