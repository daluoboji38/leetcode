package leetCode.dynamicProgramming;

import java.util.Arrays;
// Sort the items for the knapsack in ascending order, then attempt to place the i-th item into the knapsack one by one.
public class zerosOnesBagV2 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt=new int[len][2];
        for(int i=0;i<len;i++){
            String s=strs[i];
            for(int j=0;j<s.length();j++){
                cnt[i][s.charAt(j)&1]++;
            }
        }
        Arrays.sort(cnt, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        return dfs(cnt, m, n, 0);
    }

    private int dfs(int[][] cnt,int m,int n,int i){
        int len=cnt.length;
        int res=0;
        while(i<len){
            int zc=cnt[i][0];
            int oc=cnt[i][1];
            if(zc>m) break;
            i++;
            if(oc<=n) res=Math.max(res,1+dfs(cnt,m-zc,n-oc,i));
            while(i<len && cnt[i][0]==zc) i++;
        }
        return res;
    }
}
