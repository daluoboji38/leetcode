package leetCode.general.Array;

// 检查数组是否是好的
public class goodArr {
    public boolean isGood(int[] nums) {
        int n = nums.length,cnt=0;
        boolean[] has = new boolean[n];
        for(int num : nums){
            if(num<n-1) {
                if(!has[num]) {
                    has[num] = true;
                }else{
                    return false;
                }
            }else if(num==n-1){
                if(cnt<2){
                    cnt++;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    return true;
    }
}
