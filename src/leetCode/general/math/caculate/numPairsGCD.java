package leetCode.general.math.caculate;

import java.util.Arrays;

// 数对的最大公约数之和
public class numPairsGCD {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx=nums[0];
        int[] prefixGrid=new int[n];
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            prefixGrid[i]=gcd(nums[i],mx);
        }
        Arrays.sort(prefixGrid);
        long ans=0;
        int left=0,right=n-1;
        while(left<right){
            ans+=gcd(prefixGrid[left++],prefixGrid[right--]);
        }
        return ans;
    }

    private int gcd(int a,int b){
        while(a!=0){
            int tmp=a;
            a=b%a;
            b=tmp;
        }
        return b;
    }
}
