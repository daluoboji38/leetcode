package leetCode.general.Array.cnt;

// 统计主要元素子数组数目 I
public class MajeritySubArrCnt {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int cnt=0;
        int[] pre=new int[n+1];
        for(int i = 1; i < n+1; i++){
            if(nums[i-1]==target){
                pre[i]=++cnt;
            } else {
                pre[i]=cnt;
            }
        }
        int res=cnt;
        int maxl=Math.min(cnt*2-1,n);
        for(int i=2; i<=maxl; i++){
            for(int j=0;j+i<n+1;j++){
                if(pre[j+i]-pre[j]>i/2) res++;
            }
        }
        return res;
    }
}
