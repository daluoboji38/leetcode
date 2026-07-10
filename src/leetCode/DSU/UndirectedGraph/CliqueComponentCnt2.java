package leetCode.DSU.UndirectedGraph;

// 统计完全连通分量的数量
public class CliqueComponentCnt2 {
    public static int MAX=50;
    public static int[] fa=new int[MAX];
    public static int[] size=new int[MAX];
    public static int[] neighbor=new int[MAX];

    public static int find(int x){
        if(fa[x]==x) return x;
        return fa[x]=find(fa[x]);
    }

    public static void union(int a,int b){
        int faA=find(a);
        int faB=find(b);
        if(faA!=faB){
            fa[faA]=faB;
            size[faB]+=size[faA];
        }
        neighbor[a]++;
        neighbor[b]++;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        for(int i=0;i<n;i++){
            fa[i]=i;
            size[i]=1;
            neighbor[i]=0;
        }

        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }

        int[] cnt=new int[n];

        for(int i=0;i<n;i++){
            int f=find(i);
            if(neighbor[i]+1==size[f]){
                cnt[f]++;
            }
        }

        int res=0;
        for(int i=0;i<n;i++){
            if(cnt[i]==size[i]){
                res++;
            }
        }
        return res;
    }
}
