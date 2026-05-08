package leetCode.general.Array;

// 旋转函数
public class rotaFun {
    public int maxRotateFunction(int[] nums) {
        int sum=0,n=nums.length,cur=0;
        for (int i=0;i<n;i++) {
            sum += nums[i];
            cur += i*nums[i];
        }
        int ans=cur;
        for(int i=1;i<n;i++){
            cur=cur+sum-nums[n-i]*n;
            ans=Math.max(ans,cur);
        }
        return ans;
    }
}
