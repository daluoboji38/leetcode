package leetCode.general.caculate;

import java.util.Arrays;

// 排列序列
public class permutationSeq {
    public String getPermutation(int n, int k) {
        int[] mod= new int[]{1,2,6,24,120,720,5040,40320};
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();
        int q,r;
        for(int i=n-2;i>=0;i--){
            q=(k-1)/mod[i];
            k=(k-1)%mod[i]+1;
            for(int j=0;j<n;j++){
                if(!visited[j]){
                    if(q==0){
                        sb.append(j+1);
                        visited[j]=true;
                        break;
                    }
                    q--;
                }
            }
        }
        for(int j=0;j<n;j++){
            if(!visited[j]){
                sb.append(j+1);
                break;
            }
        }
        return sb.toString();
    }
}
