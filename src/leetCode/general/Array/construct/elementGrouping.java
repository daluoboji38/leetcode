package leetCode.general.Array.construct;

import java.util.stream.IntStream;

// 将元素分配到两个数组中 I
public class elementGrouping {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-1;
        int[] result = new int[n];
        result[0] = nums[0];
        result[n-1] = nums[1];
        for(int i=2;i<n;i++){
            if(result[left]>result[right]){
                result[++left]=nums[i];
            }else{
                result[--right]=nums[i];
            }
        }
        reverse(result,right,n-1);
        return result;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int[] nums,int left,int right){
        while(left<right){
            swap(nums,left++,right--);
        }
    }
}
