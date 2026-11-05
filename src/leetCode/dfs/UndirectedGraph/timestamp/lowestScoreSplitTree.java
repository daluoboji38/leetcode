package leetCode.dfs.UndirectedGraph.timestamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//从树中删除边的最小分数
public class lowestScoreSplitTree {
    public int minimumScore(int[] nums, int[][] edges) {
        int n=nums.length;
        List<Integer>[] g=new ArrayList[n];
        Arrays.setAll(g, i->new ArrayList<>());
        for(int[] e:edges){
            int x=e[0];
            int y=e[1];
            g[x].add(y);
            g[y].add(x);
        }

        int[] xor=new int[n];
        int[] in=new int[n];
        int[] out=new int[n];
        dfs(0,-1,g,nums,xor,in,out);

        int ans=Integer.MAX_VALUE;
        // enumerate deleting edge between x and x's parent, y and y's parent
        for(int x=2;x<n;x++){
            for(int y=1;y<x;y++){
                int a,b,c;
                if(isAncestor(x,y,in,out)){
                    a=xor[y];
                    b=xor[x]^a;
                    c=xor[0]^xor[x];
                }else if(isAncestor(y,x,in,out)){
                    a=xor[x];
                    b=xor[y]^a;
                    c=xor[0]^xor[y];
                }else{// not intercross
                    a=xor[x];
                    b=xor[y];
                    c=xor[0]^a^b;
                }
                ans=Math.min(ans,(Math.max(Math.max(a,b),c))-Math.min(Math.min(a,b),c));
                if(ans==0)return 0;
            }
        }
        return ans;
    }

    private int clock=0;

    private void dfs(int x,int fa,List<Integer>[] g,int[] nums,int[] xor,int[] in,int[] out){
        in[x]=++clock; // descend
        xor[x]=nums[x];
        for(int y:g[x]){
            if(y!=fa){
                dfs(y,x,g,nums,xor,in,out);
                xor[x]^=xor[y];
            }
        }
        out[x]=clock;
    }

    // is x the ancestor of y
    private boolean isAncestor(int x,int y,int[] in,int[] out){
        return in[x]<in[y]&&in[y]<=out[x];
    }
}
