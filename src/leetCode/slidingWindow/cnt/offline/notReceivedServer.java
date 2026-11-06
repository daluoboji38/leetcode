package leetCode.slidingWindow.cnt.offline;

import java.util.Arrays;

//统计没有收到请求的服务器数目
public class notReceivedServer {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a, b)->a[1]-b[1]);
        Integer[] idx=new Integer[queries.length];
        Arrays.setAll(idx,i->i);
        Arrays.sort(idx,(i,j)->queries[i]-queries[j]);
        int[] cnt=new int[n+1];
        int notReceived=n;
        int left=0;
        int right=0;

        for(int qid:idx){
            int q=queries[qid];
            // enter in
            while(right<logs.length && logs[right][1]<=q){
                int i=logs[right][0];
                if(cnt[i]==0)notReceived--;
                cnt[i]++;
                right++;
            }
            // leave out
            while(left<logs.length && logs[left][1]<q-x){
                int i=logs[left][0];
                cnt[i]--;
                if(cnt[i]==0)notReceived++;
                left++;
            }
            queries[qid]=notReceived;
        }
        return queries;
    }
}
