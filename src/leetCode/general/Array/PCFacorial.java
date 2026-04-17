package leetCode.general.Array;
// 统计计算机解锁顺序排列数
public class PCFacorial {
    public int  countPermutations(int[] complexity) {
        int MOD = 1000000007;
        long ans=1;
        for(int i=1;i<complexity.length;i++){
            if(complexity[i] <= complexity[0]){
                return 0;
            }
            ans = (ans * i) % MOD;
        }
        return (int)ans;
    }
}
