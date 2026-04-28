package leetCode.differenceArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 区间乘法查询后的异或 II
public class XORAfterRangeMultiQry2 {
    private static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        // brute force when k>=B; difference array querying when k<B
        int B = (int)Math.sqrt(queries.length);
        List<int[]>[] groups = new ArrayList[B];
        Arrays.setAll(groups, _ -> new ArrayList<>());

        for(int[] q: queries){
            int l=q[0],r=q[1],k=q[2],v=q[3];
            if(k<B){ // query group by gap k
                groups[k].add(new int[]{l,r,v});
            }else {
                for(int i=l;i<=r;i+=k){
                    nums[i]=(int)((long)nums[i]*v%MOD);
                }
            }
        }

        int[] diff=new int[n+1]; // maintain difference array, Calculate and store the multiple of the current value relative to the previous value.
        for(int k=1;k<B;k++){
            List<int[]>  g = groups[k];
            if(g.isEmpty()){continue;}

            List<int[]>[] buckets=new ArrayList[k];
            Arrays.setAll(buckets, _->new ArrayList<>());
            for(int[] t:g){ // group by start point in each k set
                buckets[t[0]%k].add(t);
            }

            for(int start=0;start<k;start++){
                List<int[]> bucket=buckets[start];
                if(bucket.isEmpty()){continue;}
                if(bucket.size()==1){
                    int[] t=bucket.get(0);
                    int l=t[0],r=t[1];
                    long v=t[2];
                    for(int i=l;i<=r;i+=k){
                        nums[i]=(int)(nums[i]*v%MOD);
                    }
                    continue;
                }

                int m=(n-start-1)/k+1;
                Arrays.fill(diff,0,m,1);
                for (int[] t:bucket) {
                    int l=t[0];
                    long v=t[2];
                    diff[l/k]=(int)(diff[l/k]*v%MOD); // start tag, means multiply diff[l/k] starting from num l/k of k set
                    int r=(t[1]-start)/k+1;
                    diff[r]=(int)(diff[r]*pow(v,MOD-2)%MOD); // end tag, = (diff[r]/v) mod MOD
                }

                long mulD=1;
                for(int i=0;i<m;i++){
                    mulD=mulD*diff[i]%MOD;
                    int j=start+i*k;
                    nums[j]=(int)(nums[j]*mulD%MOD);
                }
            }
        }

        int ans=0;
        for(int x:nums){
            ans^=x;
        }
        return ans;
    }

    private long pow(long x, int n){
        long res=1;
        for(;n>0;n/=2){
            if(n%2==1){
                res=res*x%MOD;
            }
            x=x*x%MOD;
        }
        return res;
    }
}
