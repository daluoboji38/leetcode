package leetCode.BinaryLifting_TwoPointer.Arr;

import java.util.Arrays;

// 针对图的路径存在性查询 II
// only change the order of mx and n in pa improve nearly 50% performance
public class pathExistQry2V2 {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx=new Integer[n];
        Arrays.setAll(idx, i->i);
        Arrays.sort(idx,(a,b)->nums[a]-nums[b]);

        int[] rank=new int[n];
        for(int i=0;i<n;i++)rank[idx[i]]=i;

        int mx=32-Integer.numberOfLeadingZeros(n);
        int[][] pa=new int[mx][n];
        int left=0;
        for(int i=0;i<n;i++){
            while(nums[idx[i]]-nums[idx[left]]>maxDiff){
                left++;
            }
            pa[0][i]=left; // starting from the i-th smallest element, the leftmost element can be reached by one step
        }

        for(int i=0;i<mx-1;i++){
            for(int j=0;j<n;j++){
                pa[i+1][j]=pa[i][pa[i][j]];
            }
        }

        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            if(r==l) continue;
            l=rank[l];
            r=rank[r];
            if(l>r){
                int temp=l;
                l=r;
                r=temp;
            }
            int res=0;
            for(int k=mx-1;k>=0;k--){
                if(pa[k][r]>l){
                    res|=1<<k;
                    r=pa[k][r];
                }
            }
            if(r>l)ans[i]=pa[0][r]>l?-1:res+1;
        }
        return ans;
    }
}
