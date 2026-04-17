package leetCode.general.Array;
// 是否所有1都至少相隔k个元素
public class arrayInterval {
    public boolean kLengthApart(int[] nums, int k) {
        int first =0, second =1, key=nums[0];
        if(k==0) return true;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=key){
                if(key==0 && i-first<k && first!=0)return false;
                key = nums[i];
                first = i;
                second = i+1;
            }else if(key==1)return false;
            else second++;
        }
        return true;
    }
}
