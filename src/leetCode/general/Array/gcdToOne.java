package leetCode.general.Array;
// 使数组所有元素变成1的最少操作次数
// gcd操作 greatest common divisor
public class gcdToOne {
    public int minOperations(int[] nums) {
        // the array contains 1
        int n = nums.length,gcdAll=0,cnt1=0;
        for(int x:nums){
            gcdAll=gcd(gcdAll,x);
            if(x==1) cnt1++;
        }
        if(gcdAll>1) return -1;
        if(cnt1>0) return n-cnt1;

        // find the subsequent shortest sub-array which gcd is 1
        int minSize=n;
        for(int i=0;i<n;i++){
            int g=0;
            for(int j=i;j<n;j++){
                g=gcd(g,nums[j]);
                if(g==1) {minSize=Math.min(minSize,j-i+1);
                break;}
            }
        }
        return minSize+n-2;
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
