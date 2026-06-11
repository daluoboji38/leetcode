package leetCode.greedy.Array.Recursion;

public class jumpGame2V2 {
    public int jump(int[] nums) {
        return dump(nums,0);
    }

    public int dump(int[] nums, int index) {
        if(index==nums.length-1)return 0;
        if(nums[index]+index>=nums.length-1)return 1;

        int f=index+1,t=Math.min(nums.length-1,index+nums[index]);
        int nextIndex=f;
        for(;f<=t;f++){
            if(nums[f]+f>=nums[nextIndex]+nextIndex)nextIndex=f;
        }
        return 1+dump(nums,nextIndex);
    }
}
