package leetCode.general.Array.cnt;

public class MajeritySubArrCnt2 {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] cnt = new int[2 * n + 1];
        cnt[n] = 1;
        long ans = 0;
        int s = n;
        long f = 0;
        for(int x : nums){
            if(x == target){
                f += cnt[s];
                s++;
            }else{
                s--;
                f -= cnt[s];
            }
            ans += f;
            cnt[s]++;
        }
        return ans;
    }
}
