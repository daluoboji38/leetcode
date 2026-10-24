package leetCode.greedy.Array.extremum;

import java.util.Arrays;

// 最小差值平方和
public class minSumSquare {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n= nums1.length;
        int k=k1+k2;
        long ans=0;
        long sum=0;
        for(int i=0;i<n;i++){
            nums1[i]=Math.abs(nums1[i]-nums2[i]);
            sum+=nums1[i];
            ans+=(long)nums1[i]*nums1[i];
        }
        if(sum<=k)return 0;
        Arrays.sort(nums1);
        for(int i=n-1;;i--){
            int m=n-i;
            long v=nums1[i];
            long c=m*(v-(i>0?nums1[i-1]:0));
            ans-=v*v;
            if(c<k){
                k-=c;
                continue;
            }
            v-=k/m;
            return ans+k%m*(v-1)*(v-1)+(m-k%m)*v*v;
        }
    }
}
