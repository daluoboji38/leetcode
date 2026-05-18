package leetCode.general.Array;

import java.util.stream.IntStream;

// 分割数组中数字的数位
public class sepaDigits {
    public int[] separateDigits(int[] nums) {
        int m=nums.length,l,cnt=0;
        int[] tmp=new int[m * 6];
        for(int i=m-1;i>=0;i--){
            int num=nums[i];
            while(num!=0){
                l=num%10;
                num/=10;
                tmp[cnt]=l;
                cnt++;
            }
        }
        int[] reverse=new int[cnt];
        System.arraycopy( tmp, 0, reverse, 0, cnt );
        return IntStream.rangeClosed(1, cnt).map(i->reverse[reverse.length-i]).toArray();
    }
}
