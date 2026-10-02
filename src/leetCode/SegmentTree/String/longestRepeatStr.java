package leetCode.SegmentTree.String;

// 由单个字符重复的最长子字符串
class SegmentTree{
    private record Data(int mx,int pre,int suf){
    }

    private final int n;
    private final char[] s;
    private final Data[] tree;

    public SegmentTree(char[] s) {
        n = s.length;
        this.s = s;
        tree = new Data[2<<(32-Integer.numberOfLeadingZeros(n-1))];
        build(1, 0, n-1);
    }

    public void update(int i,char val){
        update(1,0,n-1,i,val);
    }

    private void update(int node, int l, int r, int i, char val){
        if(l==r){
            s[i]=val;
            return;
        }
        int m = (l+r)>>>1;
        if(i<=m) update(node*2, l, m, i, val);
        else update(node*2+1, m+1, r, i, val);
        maintain(node,l,m,r);
    }


    public int queryAll(){
        return tree[1].mx;
    }


    private void maintain(int node, int l, int m, int r){
        Data left=tree[node*2];
        Data right=tree[node*2+1];
        int mx = Math.max(left.mx, right.mx);
        int pre = left.pre;
        int suf = right.suf;
        if(s[m]==s[m+1]){
            mx=Math.max(mx,left.suf + right.pre);
            if(left.pre==m-l+1) pre+=right.pre;
            if(right.suf==r-m) suf+=left.suf;
        }
        tree[node] = new Data(mx, pre, suf);
    }


    private void build(int node, int l, int r){
        if(l==r){
            tree[node] = new Data(1, 1, 1);
            return;
        }
        int m = (l+r)>>>2;
        build(node*2, l, m);
        build(node*2+1, m+1, r);
        maintain(node,l,m,r);
    }
}

public class longestRepeatStr {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree t = new SegmentTree(s.toCharArray());
        int q=queryIndices.length;
        int[] ans = new int[q];
        for(int i=0;i<q;i++){
            t.update(queryIndices[i], queryCharacters.charAt(i));
            ans[i] = t.queryAll();
        }
        return ans;
    }
}
