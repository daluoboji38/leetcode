package leetCode.graph.directed.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 最多的不重叠子字符串
public class MostNonOverlapSubStr {
    private int l, r;
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        List<Integer>[] pos=new ArrayList[26];
        Arrays.setAll(pos, _->new ArrayList<>());
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        // directed graph
        List<Integer>[] g=new ArrayList[26];
        Arrays.setAll(g, i->new ArrayList<>());
        for(int i = 0; i < 26; i++){
            if(pos[i].isEmpty()){continue;}
            List<Integer> p=pos[i];
            int l=p.get(0);
            int r=p.get(p.size()-1);
            for(int j = 0; j < 26; j++){
                if(j==i){continue;}
                List<Integer> q=pos[j];
                int k=lowerBound(q,l);
                if(k<q.size() && q.get(k)<=r){
                    g[i].add(j);
                }
            }
        }

        // traverse directed graph
        List<int[]> intervals=new ArrayList<>();
        boolean[] vis=new boolean[26];
        for(int i = 0; i < 26; i++){
            if(pos[i].isEmpty()){continue;}
            Arrays.fill(vis, false);
            l=n;
            r=0;
            dfs(i, pos, g, vis);
            intervals.add(new int[]{l, r});
        }

        List<String> ans=new ArrayList<>();
        intervals.sort((a, b)->a[1]-b[1]);
        int preR=-1;
        for(int[] p:intervals){
            int l=p[0];
            int r=p[1];
            if(l>preR){
                ans.add(s.substring(l, r+1));
                preR=r;
            }
        }
        return ans;
    }

    private void dfs(int x,List<Integer>[] pos,List<Integer>[] g,boolean[] vis){
        vis[x]=true;
        List<Integer> p=pos[x];
        l=Math.min(l, p.get(0));
        r=Math.max(r, p.get(p.size()-1));
        for(int j : g[x]){
            if(!vis[j]){
                dfs(j, pos, g, vis);
            }
        }
    }

    private int lowerBound(List<Integer> a,int target){
        int left=-1;
        int right=a.size();
        while(left+1<right){
            int mid=(left+right) >>> 1;
            if(a.get(mid)>=target){
                right=mid;
            }else{
                left=mid;
            }
        }
        return right; // return the least index ensuring a.get(index) >= target
    }
}
