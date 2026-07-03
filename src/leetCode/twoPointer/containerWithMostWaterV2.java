package leetCode.twoPointer;

public class containerWithMostWaterV2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max=0;
        while (left < right) {
            if(height[left] >= height[right]){
                max = Math.max(max, height[right] * (right - left));
                int tmp=height[right];
                while (right > left && height[right] <= tmp) right--;
            }else{
                max = Math.max(max, height[left] * (right - left));
                int tmp=height[left];
                while (right > left && height[left] <= tmp) left++;
            }
        }
        return max;
    }
}
