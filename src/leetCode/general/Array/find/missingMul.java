package leetCode.general.Array.find;

// 缺失的最小倍数
public class missingMul {
    public int missingMultiple(int[] nums, int k) {
        int n=nums.length;
        int[] cnt=new int[n+1];
        for(int num:nums){
            if(num%k==0 && num/k<=n){
                cnt[num/k]++;
            }
        }
        for(int i=1;i<=n;i++){
            if(cnt[i]==0){
                return i*k;
            }
        }
        return (n+1)*k;
    }
}
