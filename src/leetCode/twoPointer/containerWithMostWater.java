package leetCode.twoPointer;

// 盛最多水的容器
public class containerWithMostWater {
    public int maxArea(int[] height) {
        int left =0, right = height.length-1;
        int res = 0;
        int crrh=-1,crri=-1,drh=-1,dri=-1;
        while(left<right){
            int tmp=Math.min(height[left], height[right])*(right-left);
            if(tmp>res){
                res = tmp;
                if(height[left]==crrh){
                    drh = height[right];
                    dri = right;
                }
            }
            if(height[left]<height[right]){
                left++;
            }else{
                if(height[left]==height[right]){
                    crrh = height[right];
                    crri = right;
                }
                right--;
            }
        }
        if(crrh!=-1) res=Math.max(res,Math.min(drh,crrh)*(crri-dri));
        return res;
    }
}
