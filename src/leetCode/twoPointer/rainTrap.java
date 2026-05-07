package leetCode.twoPointer;

// 接雨水
public class rainTrap {
    public int trap(int[] height) {
        int m=height.length,sum=0,max_left=0,max_right=0,left=1,right=m-2;
        for(int i=1;i<m-1;i++){
            if(height[left-1]<height[right+1]){
                max_left=Math.max(max_left,height[left-1]);
                if(max_left>height[left]) {
                    sum += max_left - height[left];
                }
                left++;
            }else {
                max_right = Math.max(max_right, height[right + 1]);
                if (max_right > height[right]) {
                    sum += max_right - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}