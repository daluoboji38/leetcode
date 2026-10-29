package leetCode.dfs.TDArr;

import java.util.Arrays;

// //构造恰好一条路径的网格
// char[] is faster than String.repeat
public class onePathGridV2 {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        char[] buff= new char[n];
        Arrays.fill(buff,'.');
        ans[0]=String.valueOf(buff);
        Arrays.fill(buff,'#');
        buff[n-1]='.';
        String next=String.valueOf(buff);
        for(int i=1;i<m;i++){ans[i]=next;}
        return ans;
    }
}
