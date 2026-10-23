package leetCode.general.Array.extreme;

// 排序排列的最少操作数
public class sortMinOperation2 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int d=nums[1]-nums[0];
        if(Math.abs(d)!=1){
            d=nums[2]-nums[1];
            if(Math.abs(d)!=1){return -1;}
        }
        int p=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]!=d){
                if(p>0)return -1;
                p=i;
            }
        }
        if(d==1){
            return Math.min(p,n-p+2);
        }
        return Math.min(p,n-p)+1;
    }
}
