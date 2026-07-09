package leetCode.graph.undirected.ConnectedComponent;

// 针对图的路径存在性查询 I
public class pathExistQry {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] id=new int[n];
        for(int i=1;i<n;i++){
            id[i]=id[i-1];
            if(nums[i]-nums[i-1]>maxDiff)id[i]++;
        }
        boolean[] ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0],r=queries[i][1];
            ans[i]=id[l]==id[r];
        }
        return ans;
    }
}
