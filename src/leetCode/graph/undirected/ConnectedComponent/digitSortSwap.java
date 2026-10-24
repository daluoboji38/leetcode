package leetCode.graph.undirected.ConnectedComponent;

import java.util.Arrays;

// 数位和排序需要的最小交换次数
// Each k-sized connected component in the graph (with k vertices and k edges, forming a cycle) requires k−1 swap operations.
public class digitSortSwap {
    public int minSwaps(int[] nums) {
        int  n = nums.length;
        int[][] a=new int[n][3];
        for(int i=0;i<n;i++){
            int s=0;
            for(int x=nums[i];x>0;x/=10){
                s+=x%10;
            }
            a[i][0]=s;
            a[i][1]=nums[i];
            a[i][2]=i;
        }

        Arrays.sort(a,(p,q)->p[0]!=q[0]?p[0]-q[0]:p[1]-q[1]);
        int cc=0;
        for(int[] t:a){
            int i=t[2];
            if(i<0)continue;
            cc++;
            while(i>0){
                int nxt=a[i][2];
                a[i][2]=-1;
                i=nxt;
            }
        }
        return n-cc;
    }
}
