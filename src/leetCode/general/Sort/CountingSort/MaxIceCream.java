package leetCode.general.Sort.CountingSort;

// 雪糕的最大数量
public class MaxIceCream {
    public int maxIceCream(int[] costs, int coins) {
        int mx=0;
        for(int cost:costs){
            mx=Math.max(mx,cost);
        }

        int[] cnt=new int[mx+1];
        for(int cost:costs){
            cnt[cost]++;
        }

        int ans=0;
        for(int cost=1;cost<=mx && cost<=coins;cost++){
            int num=Math.min(cnt[cost],coins/cost);
            coins-=cost*num;
            ans+=num;
        }
        return ans;
    }
}
