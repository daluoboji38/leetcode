package leetCode.general.Array;

public class mkArrComplentaryV2 {
    public int minMoves(int[] nums, int limit) {
        int[] d=new int[2*limit+2];
        for(int i=0,j=nums.length-1;i<j;i++,j--){
            int p=Math.min(nums[i],nums[j]),q=Math.max(nums[i],nums[j]);
            d[p+1]--;
            d[q+limit+1]++;
            d[p+q]--;
            d[p+q+1]++;
        }
        int ans=nums.length;
        int sum=nums.length;
        for(int i=2;i<=2*limit;i++){
            sum+=d[i];
            ans=Math.min(ans,sum);
        }
        return ans;
    }
}
