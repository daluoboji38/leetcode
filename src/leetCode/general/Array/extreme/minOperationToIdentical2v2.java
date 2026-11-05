package leetCode.general.Array.extreme;

// 最小操作次数使数组元素相等 II
public class minOperationToIdentical2v2 {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        int medianIdx=n/2;
        int median=quickSelect(nums,0,n-1,medianIdx);
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(num-median);
        }
        return ans;
    }

    private int quickSelect(int[] nums,int l,int r,int k){
        if(l>=r){return nums[l];}
        int pivot=nums[l+(r-l)/2];
        int i=l-1;
        int j=r+1;
        while(i<j){
            do{
                i++;
            }while(nums[i]<pivot);
            do{
                j--;
            }while(nums[j]>pivot);
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(k<=j){
            return quickSelect(nums,l,j,k);
        }else{
            return quickSelect(nums,j+1,r,k);
        }
    }
}
