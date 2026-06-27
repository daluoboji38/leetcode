package leetCode.general.Array.extremum;

// 找到最高海拔
public class MaxAltitude {
    public int largestAltitude(int[] gain) {
        int res=Math.max(gain[0],0);
        for(int i = 1; i < gain.length; i++){
            gain[i]+=gain[i-1];
            res=Math.max(res,gain[i]);
        }
        return res;
    }
}