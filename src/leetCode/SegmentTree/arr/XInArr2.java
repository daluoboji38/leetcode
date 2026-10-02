package leetCode.SegmentTree.arr;


// 求出数组的 X 值 II
class SegmentTree {
    private record Data(int mul,int[] cnt){
    }

    private final int k;
    private final int n;
    private final Data[] tree;

    private Data mergeData(Data a, Data b){
        int[] cnt=a.cnt.clone();
        for(int rx=0;rx<k;rx++){
            cnt[a.mul*rx%k]+=b.cnt[rx];
        }
        return new Data(a.mul*b.mul%k,cnt);
    }

    private Data newData(int val){
        int mul=val%k;
        int[] cnt=new int[k];
        cnt[mul]=1;
        return new Data(mul,cnt);
    }

    private void maintain(int node){
        tree[node]=mergeData(tree[node*2],tree[node*2+1]);
    }

    private void build(int[] a,int node,int l,int r){
        if(l==r){
            tree[node]=newData(a[l]);
            return;
        }
        int m=(r+l)/2;
        build(a,node*2,l,m);
        build(a,node*2+1,m+1,r);
        maintain(node);
    }

    public SegmentTree(int[] a,int k){
        this.k=k;
        n=a.length;
        tree=new Data[2<<(32-Integer.numberOfLeadingZeros(n-1))];
        build(a,1,0,n-1);
    }

    private void update(int node,int l,int r,int i,int val){
        if(l==r){
            tree[node]=newData(val);
            return;
        }
        int m=(r+l)/2;
        if(i<=m){
            update(node*2,l,m,i,val);
        }else{
            update(node*2+1,m+1,r,i,val);
        }
        maintain(node);
    }

    public void update(int i,int val){
        update(1,0,n-1,i,val);;
    }

    private Data query(int node,int l,int r,int ql,int qr){
        if(ql<=l&&r<=qr){
            return tree[node];
        }
        int m=(r+l)/2;
        if(qr<=m){
            return query(node*2,l,m,ql,qr);
        }else if(ql>m){
            return query(node*2+1,m+1,r,ql,qr);
        }
        Data lRes=query(node*2,l,m,ql,qr);
        Data rRes=query(node*2+1,m+1,r,ql,qr);
        return mergeData(lRes,rRes);
    }

    public int query(int ql,int qr,int x){
        return query(1,0,n-1,ql,qr).cnt[x];
    }
}

public class XInArr2{
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree t=new SegmentTree(nums,k);
        int n=nums.length;
        int[] ans=new int[queries.length];
        for(int qi=0;qi<queries.length;qi++){
            int[] q=queries[qi];
            t.update(q[0],q[1]);
            ans[qi]=t.query(q[2],n-1,q[3]);
        }
        return ans;
    }
}