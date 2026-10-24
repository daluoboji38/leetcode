package leetCode.Contribute.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 统计为蚁群构筑房间的不同顺序
public class roomOrderCnt {
    private static final int MOD = 1000000007;
    private long prod=1; // denominator
    public int waysToBuildRooms(int[] prevRoom) {
        int n = prevRoom.length;
        List<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, i->new ArrayList<>());
        long fac=1; // Numerator
        for(int i=1;i<n;i++){
            fac=fac*(i+1)%MOD;
            g[prevRoom[i]].add(i);
        }
        dfs(0,g);
        return (int)(fac*pow(prod,MOD-2)%MOD);
    }

    private int dfs(int x,List<Integer>[] g){
        int size=1;
        for(int y:g[x]){
            size+=dfs(y,g);
        }
        prod=prod*size%MOD;
        return size;
    }

    private long pow(long x,int n){
        long res=1;
        for(;n>0;n/=2){
            if(n%2>0){res=res*x%MOD;}
            x=x*x%MOD;
        }
        return res;
    }
}
