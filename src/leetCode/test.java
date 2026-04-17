package leetCode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class test {
    public static void main(String[] args) {
        long s=780;
        int[] nums=new int[]{13,17,9,18,16,6,4,11,7,18,8,15,12};
        for (int i=0;i<nums.length;i++){
            s=(s * nums[i])% 1000000007;
        }
        System.out.println(s);
    }
}
