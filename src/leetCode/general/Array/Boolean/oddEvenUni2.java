package leetCode.general.Array.Boolean;

import java.util.Arrays;
/*
even-odd=odd
even-even=even
odd-odd=even
odd can't trun into even
even can turn into odd
*/
// 构造奇偶一致的数组 II
public class oddEvenUni2 {
    /*public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int me=Integer.MAX_VALUE,mo=Integer.MAX_VALUE,pre=Integer.MIN_VALUE;
        Arrays.sort(nums1);
        if(nums1[0]==1 || n==1)return true;
        for(int num:nums1){
            if(num%2==0){
                if(me==Integer.MAX_VALUE) {
                    me = num;
                }
                if(pre!=Integer.MIN_VALUE) {
                    mo = Math.min(mo, num - pre);
                }
            }else if(mo==Integer.MAX_VALUE){
                mo=num;
            }else{
                pre=num;
                continue;
            }
            if(mo<me)return true;
        }
        return me==Integer.MAX_VALUE || mo==Integer.MAX_VALUE;
    }*/
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0],cnt=0;
        for(int num : nums1) {
            if(num%2==0) {cnt++;}
            min=Math.min(min,num);
        }
        return min%2==1 || cnt==nums1.length || cnt==0;
    }
}
