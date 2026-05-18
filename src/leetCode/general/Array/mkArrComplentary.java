package leetCode.general.Array;

// 使数组互补的最少操作次数
public class mkArrComplentary {
    public int minMoves(int[] nums, int limit) {
        int n=nums.length;
        int[] diff=new int[2*limit+2]; // diff denotes the sum of a pair of values with complementary indices.

        for(int i=0;i<n/2;i++){
            int x=nums[i];
            int y=nums[n-1-i];
            int l=Math.min(x,y)+1;
            int r=Math.max(x,y)+limit;

            // prefixsum
            /*diff[2]+=2;
            diff[l]-=2;

            diff[l]++;
            diff[r+1]--;

            diff[x+y]--;
            diff[x+y+1]++;

            diff[r+1]+=2;*/
            diff[l]--;
            diff[x+y]--;
            diff[x+y+1]++;
            diff[r+1]++;
        }

        int ans=Integer.MAX_VALUE;
        int sum=n;

        for(int i=2;i<=2*limit;i++){
            sum+=diff[i];
            ans=Math.min(ans,sum);
        }
        return ans;
    }
}
