package leetCode.general.Array.extremum;

// 最大子数组总值 I
public class MaxSubArrSum {
    public long maxTotalValue(int[] nums, int k) {
        int mn=Integer.MAX_VALUE,mx=0;
        for(int x:nums){
            mn=Math.min(mn,x);
            mx=Math.max(mx,x);
        }
        return (long)(mx-mn)*k;
        /*
        int n=nums.length,cnt=0,left=0,right=n-1;
        long ans=0;
        int[][] extremum=new int[2][2];
        update(extremum,nums,left,right);

        if (extremum[0][0] > extremum[1][0]) {
            cnt = (extremum[0][1] - left + 1) * (right - extremum[1][1] + 1);
            left=extremum[1][0]+1;
            right=extremum[0][0]-1;
        } else {
            cnt = (extremum[1][1] - left + 1) * (right - extremum[0][1] + 1);
            left=extremum[0][0]+1;
            right=extremum[1][0]-1;
        }
        if (cnt >= k) {
            return (long)(extremum[1][1]-extremum[0][1])*k;
        }else{
            ans=(long)(extremum[1][1]-extremum[0][1])*cnt;
        }
        k-=cnt;

        while(left<=right) {
            update(extremum,nums,left,right);

        }*/
    }

    /*private void update(int[][] extremum,int[] nums,int left,int right){
        for(int i=left;i<=right;i++){
            if(nums[i]<extremum[0][1]){
                extremum[0][0]=i;
                extremum[0][1]=nums[i];
            }else if(nums[i]>extremum[1][1]){
                extremum[1][0]=i;
                extremum[1][1]=nums[i];
            }
        }
    }*/
}
