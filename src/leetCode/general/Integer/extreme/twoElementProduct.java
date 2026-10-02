package leetCode.general.Integer.extreme;

public class twoElementProduct {
    public int maxProduct(int[] nums){
        int n=nums.length;
        int mx=0,mx2=0;
        for (int k=0;k<n;k++){
            int v=nums[k];
            if(v>mx){
                mx2=mx;
                mx=v;
            }else if(v>=mx2){
                mx2=v;
            }
        }
        return (mx-1)*(mx2-1);
    }
}
