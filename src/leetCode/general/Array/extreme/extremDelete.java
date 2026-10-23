package leetCode.general.Array.extreme;

// 从数组中移除最大值和最小值
public class extremDelete {
    public int minimumDeletions(int[] nums) {
        int maxIdx=0,minIdx=0,max=nums[0],min=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<min){
                min=nums[i];
                minIdx=i;
            }else if(nums[i]>max){
                max=nums[i];
                maxIdx=i;
            }
        }
        if(maxIdx<minIdx){
            int tmp=minIdx;
            minIdx=maxIdx;
            maxIdx=tmp;
        }

        return Math.min(Math.min(n-minIdx,maxIdx+1),n-maxIdx+minIdx+1);
    }
}
