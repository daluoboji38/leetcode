package leetCode.general.Array;

// 最大连续 1 的个数
public class consArr {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0,cnt=0;
        for(int x:nums){
            if(x==0){if(ans<cnt) ans=cnt;cnt=0;}
            else{
                cnt++;
            }
        }
        return Math.max(ans, cnt);
    }
}
