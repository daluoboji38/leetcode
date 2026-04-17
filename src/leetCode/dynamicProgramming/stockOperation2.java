package leetCode.dynamicProgramming;
// 买卖股票的最佳时机2
public class stockOperation2 {
    public int maxProfit(int[] prices) {
        int min =prices[0],ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[i-1]){
                if(i>1 && prices[i-1]>min) ans+=prices[i-1]-min;
                min=prices[i];
            }
        }
        if(prices[prices.length-1]>min) ans+=prices[prices.length-1]-min;
        return ans;
    }
}
