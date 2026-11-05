package leetCode.twoPointer.cnt;

import java.util.ArrayList;
import java.util.Arrays;

// 两个数组间的距离值
public class distanceVal {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int ans=0;
        int j=0;
        for(int x:arr1){
            while(j<arr2.length&&arr2[j]<x-d){j++;}
            if(j==arr2.length||arr2[j]>x+d){ans++;}
        }
        return ans;
    }
}
