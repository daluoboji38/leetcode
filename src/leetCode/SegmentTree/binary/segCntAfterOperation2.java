package leetCode.SegmentTree.binary;

import java.util.ArrayList;
import java.util.List;

// 操作后最大活跃区段数 II
public class segCntAfterOperation2 {
    private record Pair(int l, int r) {
    } // Left Closed, Right Open

    private static class SparseTable {
        private final int[][] st;

        SparseTable(List<Pair> a) {
            int n = a.size()-1;
            int w=32-Integer.numberOfLeadingZeros(n);
            st = new int[w][n];
            for(int j=0;j<n;j++){
                st[0][j]=a.get(j).r-a.get(j).l+a.get(j+1).r-a.get(j+1).l;
            }
            for(int i=1;i<w;i++){
                for(int j=0;j+(1<<i)<=n;j++){
                    st[i][j]=Math.max(st[i-1][j],st[i-1][j+(1<<(i-1))]);
                }
            }
        }

        int query(int l, int r) {
            if(l>=r) return 0;
            int k = 32 - Integer.numberOfLeadingZeros(r - l)-1;
            return Math.max(st[k][l], st[k][r - (1 << k)]);
        }
    }


    public List<Integer> maxActiveSectionsAfterTrade(String S, int[][] queries) {
        char[] s=S.toCharArray();
        int n=s.length;
        int total1=0;
        int[] belong=new int[n]; // mark
        List<Pair> a=new ArrayList<>();
        a.add(new Pair(-1, -1));
        int start=0;
        for(int i=0;i<n;i++){
            belong[i]=a.size();
            if(i==n-1 || s[i]!=s[i+1]){
                if(s[i]=='1'){
                    total1+=i-start+1;
                }else{
                    a.add(new Pair(start, i+1));
                }
                start=i+1;
            }
        }
        a.add(new Pair(n+1, n+1));

        SparseTable st=new SparseTable(a);
        List<Integer> ans=new ArrayList<>(queries.length);
        for(int[] q:queries){
            int ql=q[0], qr=q[1];
            int i=belong[ql]; // the first complete interval
            if(ql>0 && s[ql]=='0' && s[ql-1]=='0')i++; // i is int the Incomplete interval
            int j=belong[qr]-1; // the last complete interval
            if(qr<n-1 && s[qr]=='0' && s[qr+1]=='1')j++;// j at the right endpoint of complete interval, no need to minus 1
            qr++;

            int mx=0;
            if(i<=j){
                int full=st.query(i, j);
                int sl=merge(a.get(i-1).r-ql, a.get(i).r-a.get(i).l);
                int sr=merge(qr-a.get(j+1).l, a.get(j).r-a.get(j).l);
                mx=Math.max(full,Math.max(sl,sr));
            }else if(i==j+1)
                mx=merge(a.get(i-1).r-ql, qr-a.get(j+1).l);
            ans.add(total1+mx);
        }
        return ans;
    }
    private int merge(int x, int y) {
        return x>0 && y>0 ? x+y : 0;
    }
}
