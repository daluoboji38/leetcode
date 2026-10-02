package leetCode.dynamicProgramming.tableSweeping;
// 求出数组的 X 值 I
public class XInArr {
    public long[] resultArray(int[] nums, int k) {
        long[] ans=new long[k];
        int[] f=new int[k];
        for(int v: nums){
            v%=k;
            int[] nf=new int[k];
            nf[v]=1;
            for(int y=0;y<k;y++){
                nf[y*v%k]+=f[y];
            }
            f=nf;
            for(int x=0;x<k;x++) ans[x]+=f[x];
        }
        return ans;
    }
}
