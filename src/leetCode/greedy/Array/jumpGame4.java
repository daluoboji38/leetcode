package leetCode.greedy.Array;

// 跳跃游戏 II
public class jumpGame4 {
    public int jump(int[] nums) {
        int n = nums.length,max=nums[0],idx=-1,start,end,ans=0;
        if(n==1)return 0;
        while(true){
            start=idx+1;
            ans++;
            if(max>=n-1)return ans;
            end=max;
            for(int i=start;i<=end;i++){
                nums[i]+=i;
                max=Math.max(max,nums[i]);
            }
            idx=end;
        }
    }
}
