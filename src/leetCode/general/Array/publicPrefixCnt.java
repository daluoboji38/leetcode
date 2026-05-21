package leetCode.general.Array;

// 找到两个数组的前缀公共数组
public class publicPrefixCnt {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length,cnt=0;
        boolean[] tag = new boolean[n+1];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(helper(A,tag,i)) cnt++;
            if(helper(B,tag,i)) cnt++;
            ans[i]=cnt;
        }
        return ans;
    }

    private boolean helper(int[] srv,boolean[] tag,int i){
        if(tag[srv[i]]){
            return true;
        }else{
            tag[srv[i]] = true;
            return false;
        }
    }
}
