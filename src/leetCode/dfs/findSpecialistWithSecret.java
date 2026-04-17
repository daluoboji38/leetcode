package leetCode.dfs;

import java.util.*;

// 找到知晓秘密的所有专家
public class findSpecialistWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings,int firstPerson){
        // sort meeting by time ascending
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        // each member of multiAdj is the meeting at that time
        List<Map<Integer, List<Integer>>> multiAdj = new ArrayList<>();
        for (int i = 0; i < meetings.length; i++) {
            if(i == 0 || meetings[i][2] > meetings[i-1][2]){
                multiAdj.add(new HashMap<>());
            }
            Map<Integer, List<Integer>> adj = multiAdj.get(multiAdj.size()-1);
            int u = meetings[i][0], v = meetings[i][1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        boolean[] visited = new boolean[n];
        visited[0]=true;
        visited[firstPerson]=true;

        for(Map<Integer, List<Integer>> adj : multiAdj){
            for(int p : adj.keySet()){
                if(visited[p]){
                    dfs(p, adj, visited);
                }
                }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]){
                result.add(i);
            }
        }
        return result;


    }


    private void dfs(int u,Map<Integer, List<Integer>> adj, boolean[] visited){
        if(adj.get(u) == null) return;

        for(int v : adj.get(u)){
            if(!visited[v]){
                visited[v] = true;
                dfs(v, adj, visited);
            }
        }
    }
}
