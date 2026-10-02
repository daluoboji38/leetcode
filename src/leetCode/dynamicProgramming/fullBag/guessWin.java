package leetCode.dynamicProgramming.fullBag;

// 预测赢家
public class guessWin {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] f=new int[n];

        for(int i=n-1;i>=0;i--){
            f[i]=nums[i];
            for(int j=i+1;j<n;j++){
                f[j]=Math.max(nums[i]-f[j],nums[j]-f[j-1]);
            }
        }
        return f[n-1]>0;

    }
}
