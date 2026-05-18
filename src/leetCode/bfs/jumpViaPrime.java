package leetCode.bfs;

import java.util.*;

// 通过质数传送到达终点的最少跳跃次数
public class jumpViaPrime {
    private static final int MX =1_000_001;
    private static final List<Integer>[] primeFactors = new ArrayList[MX];
    private static boolean initialized=false;

    private void init(){
        if (initialized) return;
        Arrays.setAll(primeFactors, _ -> new ArrayList<>());
        for (int i = 2; i < MX; i++) {
            if (primeFactors[i].isEmpty()) {
                for (int j = i; j < MX; j += i) {
                    primeFactors[j].add(i);
                }
            }
        }
        initialized=true;
    }

    public int minJumps(int[] nums) {
        init();

        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x=nums[i];
            if(primeFactors[x].size()==1){
                groups.computeIfAbsent(x, _ -> new ArrayList<>()).add(i);
            }
        }

        int ans=0;
        boolean[] vis=new boolean[n];
        vis[n-1]=true;
        List<Integer> q=List.of(n-1);

        while(true){
            List<Integer> tmp=q;
            q=new ArrayList<>();
            for(int i:tmp){
                if(i==0)return ans;
                if(!vis[i-1]){
                    vis[i-1]=true;
                    q.add(i-1);
                }
                if(i+1<n && !vis[i+1]){
                    vis[i+1]=true;
                    q.add(i+1);
                }
                for(int p:primeFactors[nums[i]]){
                    List<Integer> idx=groups.remove(p); // get, delete and assign p
                    if(idx!=null){
                        for(int j:idx){
                            if(!vis[j]){
                                vis[j]=true;
                                q.add(j);
                            }
                        }
                    }
                }
            }
            ans++;
        }
    }

}
