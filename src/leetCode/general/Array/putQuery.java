package leetCode.general.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// 物块放置查询
public class putQuery {
    public List<Boolean> getResults(int[][] queries) {
        int m=0;
        for(int[] q : queries){
            m=Math.max(m,q[1]);
        }
        m++;

        TreeSet<Integer> set = new TreeSet<>(List.of(0, m));
        int[] t = new int[2<<(32-Integer.numberOfLeadingZeros(m))];

        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries){
            int x=q[1];
            int pre=set.floor(x-1);
            if(q[0]==1){
                int nxt=set.ceiling(x);
                set.add(x);
                update(t,1,0,m,x,x-pre);
                update(t,1,0,m,nxt,nxt-x);
            }else {
                int maxGap=Math.max(query(t,1,0,m,pre),x-pre);
                ans.add(maxGap>=q[2]);
            }
        }
        return ans;
}
    private void update(int[] t,int o,int l,int r,int i,int val){
        if(l==r){
            t[o]=val;
            return;
        }
        int m=(l+r)/2;
        if(i<=m){
            update(t,o*2,l,m,i,val);
        }else{
            update(t,o*2+1,m+1,r,i,val);
        }
        t[o]=Math.max(t[o*2],t[o*2+1]);
    }

    private int query(int[] t,int o,int l, int r,int R){
        if(r<=R){
            return t[o];
        }
        int m=(l+r)/2;
        if(R<=m){
            return query(t,o*2,l,m,R);
        }
        return Math.max(t[o*2],query(t,o*2+1,m+1,r,R));
    }
}


