package leetCode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 跳跃游戏 IV
public class jumpGame4 {
    public int minJumps(int[] arr) {
        int n=arr.length;
        Map<Integer, List<Integer>> groups=new HashMap<>();
        for(int i=0;i<n;i++){
            groups.computeIfAbsent(arr[i], _ -> new ArrayList<>()).add(i);
        }

        int ans=0;
        boolean[] vis=new boolean[n];
        vis[0]=true;
        List<Integer> q=List.of(0);

        while(true){
            List<Integer> tmp=q;
            q=new ArrayList<>();
            for(int i:tmp){
                if(i==n-1)return ans;
                if(i>0 && !vis[i-1]){
                    vis[i-1]=true;
                    q.add(i-1);
                }
                if(i+1<n && !vis[i+1]){
                    vis[i+1]=true;
                    q.add(i+1);
                }
                List<Integer> idx=groups.remove(arr[i]);
                if(idx!=null){
                    for(int j:idx){
                        if(!vis[j]){
                            vis[j]=true;
                            q.add(j);
                        }
                    }
                }
            }
            ans++;
        }
    }
}
