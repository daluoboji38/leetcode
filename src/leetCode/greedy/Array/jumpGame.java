package leetCode.greedy.Array;

// 跳跃游戏
public class jumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(nums[0]==0) return n==1;
        int nearest=n-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]+i>=nearest) nearest=i;
        }
        return nearest==0;
    }
}
