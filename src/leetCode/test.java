package leetCode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    public static void main(String[] args) {
        int ans=0;
        int[] nums=new int[]{1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<nums.length;i++){
            ans+=nums[i]*i;
        }
        System.out.println(ans);
    }
}
